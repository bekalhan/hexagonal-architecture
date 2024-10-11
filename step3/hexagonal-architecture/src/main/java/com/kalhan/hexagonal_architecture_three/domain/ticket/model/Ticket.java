package com.kalhan.hexagonal_architecture_three.domain.ticket.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket {
    private Long id;
    private Long accountId;
    private Long meetupId;
    private LocalDateTime reserveDate;
    private BigDecimal price;
    private Integer count;

    public Ticket(Long id, Long accountId, Long meetupId, LocalDateTime reserveDate, BigDecimal price, Integer count) {
        this.id = id;
        this.accountId = accountId;
        this.meetupId = meetupId;
        this.reserveDate = reserveDate;
        this.price = price;
        this.count = count;
    }

    private Ticket(Builder builder) {
        setId(builder.id);
        setAccountId(builder.accountId);
        setMeetupId(builder.meetupId);
        setReserveDate(builder.reserveDate);
        setPrice(builder.price);
        setCount(builder.count);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getMeetupId() {
        return meetupId;
    }

    public void setMeetupId(Long meetupId) {
        this.meetupId = meetupId;
    }

    public LocalDateTime getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDateTime reserveDate) {
        this.reserveDate = reserveDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(accountId, ticket.accountId) && Objects.equals(meetupId, ticket.meetupId) && Objects.equals(reserveDate, ticket.reserveDate) && Objects.equals(price, ticket.price) && Objects.equals(count, ticket.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, meetupId, reserveDate, price, count);
    }

    public static final class Builder {
        private Long id;
        private Long accountId;
        private Long meetupId;
        private LocalDateTime reserveDate;
        private BigDecimal price;
        private Integer count;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
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

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
