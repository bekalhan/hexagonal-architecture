package com.kalhan.hexagonal_architecture_three.infrastructure.adapter.payment.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

    private Long id;
    private Long accountId;
    private BigDecimal price;
    private String referenceCode;
}