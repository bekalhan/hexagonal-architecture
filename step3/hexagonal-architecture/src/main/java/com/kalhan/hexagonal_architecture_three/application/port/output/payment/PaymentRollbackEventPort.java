package com.kalhan.hexagonal_architecture_three.application.port.output.payment;

import com.kalhan.hexagonal_architecture_three.domain.common.event.EventPublisher;
import com.kalhan.hexagonal_architecture_three.domain.payment.event.PaymentRollbackEvent;

public interface PaymentRollbackEventPort extends EventPublisher<PaymentRollbackEvent> {
    void publish(PaymentRollbackEvent paymentRollbackEvent);
}
