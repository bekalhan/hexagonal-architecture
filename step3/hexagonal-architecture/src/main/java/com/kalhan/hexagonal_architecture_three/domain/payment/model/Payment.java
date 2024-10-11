package com.kalhan.hexagonal_architecture_three.domain.payment.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Payment {
    private Long id;
    private Long accountId;
    private BigDecimal price;
    private String referenceCode;

    public Payment(Long id, Long accountId, BigDecimal price, String referenceCode) {
        this.id = id;
        this.accountId = accountId;
        this.price = price;
        this.referenceCode = referenceCode;
    }

    private Payment(Builder builder) {
        setId(builder.id);
        setAccountId(builder.accountId);
        setPrice(builder.price);
        setReferenceCode(builder.referenceCode);
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }


    public static final class Builder {
        private Long id;
        private Long accountId;
        private BigDecimal price;
        private String referenceCode;

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

        public Builder price(BigDecimal val) {
            price = val;
            return this;
        }

        public Builder referenceCode(String val) {
            referenceCode = val;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(accountId, payment.accountId) && Objects.equals(price, payment.price) && Objects.equals(referenceCode, payment.referenceCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, price, referenceCode);
    }
}
