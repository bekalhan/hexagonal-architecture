package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.payment.rest.data.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentCreateRequest {

    private Long accountId;
    private BigDecimal price;
    private String referenceCode;
}