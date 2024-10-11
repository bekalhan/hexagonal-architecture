package com.kalhan.hexagonal_architecture_three.application.port.output.payment;


import com.kalhan.hexagonal_architecture_three.domain.payment.model.Payment;
import com.kalhan.hexagonal_architecture_three.domain.payment.usecase.PaymentCreate;

public interface PaymentOutputPort {

    Payment pay(PaymentCreate paymentCreate);
}