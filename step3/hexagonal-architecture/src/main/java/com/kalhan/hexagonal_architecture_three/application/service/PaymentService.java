package com.kalhan.hexagonal_architecture_three.application.service;

import com.kalhan.hexagonal_architecture_three.application.port.output.payment.PaymentOutputPort;
import com.kalhan.hexagonal_architecture_three.domain.payment.model.Payment;
import com.kalhan.hexagonal_architecture_three.domain.payment.usecase.PaymentCreate;
import com.kalhan.hexagonal_architecture_three.infrastructure.input.rest.data.properties.PaymentApiProperties;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.payment.rest.data.request.PaymentCreateRequest;
import com.kalhan.hexagonal_architecture_three.infrastructure.adapter.payment.rest.data.response.PaymentResponse;
import com.kalhan.hexagonal_architecture_three.infrastructure.input.rest.data.response.Response;
import com.kalhan.hexagonal_architecture_three.infrastructure.common.customizedexception.exception.TicketApiBusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static org.springframework.http.HttpMethod.POST;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(name = "adapters.payment.enabled", havingValue = "true")
public class PaymentService implements PaymentOutputPort {
    private final RestTemplate restTemplate;
    private final PaymentApiProperties paymentApiProperties;
    private final ParameterizedTypeReference<Response<PaymentResponse>> paymentResponseType = new ParameterizedTypeReference<>() {
    };

    @Override
    @Retryable(value = {Exception.class},
            maxAttemptsExpression = "${adapters.payment.retryAttempts}",
            backoff = @Backoff(delayExpression = "${adapters.payment.retryDelay}"))
    public Payment pay(PaymentCreate paymentCreate) {

        var paymentCreateRequest = PaymentCreateRequest.builder()
                .accountId(paymentCreate.getAccountId())
                .price(paymentCreate.getPrice())
                .referenceCode(paymentCreate.getReferenceCode())
                .build();

        var response = callApi(paymentCreateRequest, preparePaymentUrl());

        return Payment.Builder.newBuilder()
                .id(response.getId())
                .accountId(response.getAccountId())
                .price(response.getPrice())
                .referenceCode(response.getReferenceCode())
                .build();
    }

    @Recover
    public Payment pay(TicketApiBusinessException e, PaymentCreate paymentCreate) {
        log.error("Couldn't connect to payment api to do payment for {}", paymentCreate, e);
        throw e;
    }

    @Recover
    public Payment pay(Exception e, PaymentCreate paymentCreate) {
        log.error("Couldn't connect to payment api to do payment for {}", paymentCreate, e);
        throw new TicketApiBusinessException("ticketapi.payment.client.error");
    }

    private PaymentResponse callApi(PaymentCreateRequest paymentCreateRequest, String url) {
        var exchange = restTemplate.exchange(url, POST, new HttpEntity<>(paymentCreateRequest), this.paymentResponseType);
        var body = exchange.getBody();

        if (Objects.isNull(body)) throw new TicketApiBusinessException("ticketapi.payment.emptyResponse");
        return body.getData();
    }

    private String preparePaymentUrl() {
        return paymentApiProperties.getBaseUrl() + paymentApiProperties.getPaymentPath();
    }
}
