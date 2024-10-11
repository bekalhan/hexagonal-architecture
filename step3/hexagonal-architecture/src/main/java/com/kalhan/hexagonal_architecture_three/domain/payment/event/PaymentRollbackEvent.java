package com.kalhan.hexagonal_architecture_three.domain.payment.event;

import com.kalhan.hexagonal_architecture_three.domain.common.model.Event;
import com.kalhan.hexagonal_architecture_three.domain.common.util.CurrentTimeFactory;
import com.kalhan.hexagonal_architecture_three.domain.payment.model.Payment;

import java.time.LocalDateTime;

public class PaymentRollbackEvent implements Event {

    private LocalDateTime eventCreatedAt;
    private Long id;

    public PaymentRollbackEvent(LocalDateTime eventCreatedAt, Long id) {
        this.eventCreatedAt = eventCreatedAt;
        this.id = id;
    }

    public PaymentRollbackEvent() {
    }

    private PaymentRollbackEvent(Builder builder) {
        eventCreatedAt = builder.eventCreatedAt;
        id = builder.id;
    }

    public LocalDateTime getEventCreatedAt() {
        return eventCreatedAt;
    }

    public Long getId() {
        return id;
    }


    public static PaymentRollbackEvent from(Payment payment) {
        return PaymentRollbackEvent.Builder.newBuilder()
                .eventCreatedAt(CurrentTimeFactory.now())
                .id(payment.getId())
                .build();
    }


    public static final class Builder {
        private LocalDateTime eventCreatedAt;
        private Long id;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder eventCreatedAt(LocalDateTime val) {
            eventCreatedAt = val;
            return this;
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public PaymentRollbackEvent build() {
            return new PaymentRollbackEvent(this);
        }
    }
}
