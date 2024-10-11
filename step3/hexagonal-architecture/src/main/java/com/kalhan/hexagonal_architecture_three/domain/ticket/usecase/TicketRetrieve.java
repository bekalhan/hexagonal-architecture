package com.kalhan.hexagonal_architecture_three.domain.ticket.usecase;

import com.kalhan.hexagonal_architecture_three.domain.common.model.UseCase;

import java.util.Objects;

public class TicketRetrieve implements UseCase {

    private Long accountId;

    public TicketRetrieve(Long accountId) {
        this.accountId = accountId;
    }

    private TicketRetrieve(Builder builder) {
        setAccountId(builder.accountId);
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketRetrieve that = (TicketRetrieve) o;
        return Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountId);
    }



    public static final class Builder {
        private Long accountId;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder accountId(Long val) {
            accountId = val;
            return this;
        }

        public TicketRetrieve build() {
            return new TicketRetrieve(this);
        }
    }
}