package com.kalhan.hexagonal_architecture_three.domain.ticket.event;

import com.kalhan.hexagonal_architecture_three.domain.common.model.Event;
import com.kalhan.hexagonal_architecture_three.domain.common.util.CurrentTimeFactory;
import com.kalhan.hexagonal_architecture_three.domain.payment.model.Payment;
import com.kalhan.hexagonal_architecture_three.domain.ticket.model.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class TicketReservedEvent implements Event {
    private LocalDateTime eventCreatedAt;
    private Long id;
    private Long accountId;
    private Long meetupId;
    private LocalDateTime reserveDate;
    private BigDecimal price;
    private Integer count;
    private Long paymentId;

    public TicketReservedEvent(LocalDateTime eventCreatedAt, Long id, Long accountId, Long meetupId, LocalDateTime reserveDate, BigDecimal price, Integer count, Long paymentId) {
        this.eventCreatedAt = eventCreatedAt;
        this.id = id;
        this.accountId = accountId;
        this.meetupId = meetupId;
        this.reserveDate = reserveDate;
        this.price = price;
        this.count = count;
        this.paymentId = paymentId;
    }

    public TicketReservedEvent() {
    }

    private TicketReservedEvent(Builder builder) {
        eventCreatedAt = builder.eventCreatedAt;
        id = builder.id;
        accountId = builder.accountId;
        meetupId = builder.meetupId;
        reserveDate = builder.reserveDate;
        price = builder.price;
        count = builder.count;
        paymentId = builder.paymentId;
    }

    public LocalDateTime getEventCreatedAt() {
        return eventCreatedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getMeetupId() {
        return meetupId;
    }

    public LocalDateTime getReserveDate() {
        return reserveDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketReservedEvent that = (TicketReservedEvent) o;
        return Objects.equals(eventCreatedAt, that.eventCreatedAt) && Objects.equals(id, that.id) && Objects.equals(accountId, that.accountId) && Objects.equals(meetupId, that.meetupId) && Objects.equals(reserveDate, that.reserveDate) && Objects.equals(price, that.price) && Objects.equals(count, that.count) && Objects.equals(paymentId, that.paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventCreatedAt, id, accountId, meetupId, reserveDate, price, count, paymentId);
    }



    public static TicketReservedEvent from(Ticket ticket, Payment payment) {
        return TicketReservedEvent.Builder.newBuilder()
                .eventCreatedAt(CurrentTimeFactory.now())
                .id(ticket.getId())
                .accountId(ticket.getAccountId())
                .meetupId(ticket.getMeetupId())
                .reserveDate(ticket.getReserveDate())
                .price(ticket.getPrice())
                .count(ticket.getCount())
                .paymentId(payment.getId())
                .build();
    }

    public static final class Builder {
        private LocalDateTime eventCreatedAt;
        private Long id;
        private Long accountId;
        private Long meetupId;
        private LocalDateTime reserveDate;
        private BigDecimal price;
        private Integer count;
        private Long paymentId;

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

        public Builder accountId(Long val) {
            accountId = val;
            return this;
        }

        public Builder meetupId(Long val) {
            meetupId = val;
            return this;
        }

        public Builder reserveDate(LocalDateTime val) {
            reserveDate = val;
            return this;
        }

        public Builder price(BigDecimal val) {
            price = val;
            return this;
        }

        public Builder count(Integer val) {
            count = val;
            return this;
        }

        public Builder paymentId(Long val) {
            paymentId = val;
            return this;
        }

        public TicketReservedEvent build() {
            return new TicketReservedEvent(this);
        }
    }
}
