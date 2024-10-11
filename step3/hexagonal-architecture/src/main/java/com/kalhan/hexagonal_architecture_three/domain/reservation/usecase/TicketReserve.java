package com.kalhan.hexagonal_architecture_three.domain.reservation.usecase;

import com.kalhan.hexagonal_architecture_three.domain.common.model.UseCase;

import java.util.Objects;

public class TicketReserve implements UseCase {
    private Long accountId;
    private Long meetupId;
    private Integer count;
    private String referenceCode;

    public TicketReserve(Long accountId, Long meetupId, Integer count, String referenceCode) {
        this.accountId = accountId;
        this.meetupId = meetupId;
        this.count = count;
        this.referenceCode = referenceCode;
    }

    private TicketReserve(Builder builder) {
        setAccountId(builder.accountId);
        setMeetupId(builder.meetupId);
        setCount(builder.count);
        setReferenceCode(builder.referenceCode);
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketReserve that = (TicketReserve) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(meetupId, that.meetupId) && Objects.equals(count, that.count) && Objects.equals(referenceCode, that.referenceCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, meetupId, count, referenceCode);
    }

    public static final class Builder {
        private Long accountId;
        private Long meetupId;
        private Integer count;
        private String referenceCode;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder accountId(Long val) {
            accountId = val;
            return this;
        }

        public Builder meetupId(Long val) {
            meetupId = val;
            return this;
        }

        public Builder count(Integer val) {
            count = val;
            return this;
        }

        public Builder referenceCode(String val) {
            referenceCode = val;
            return this;
        }

        public TicketReserve build() {
            return new TicketReserve(this);
        }
    }
}
