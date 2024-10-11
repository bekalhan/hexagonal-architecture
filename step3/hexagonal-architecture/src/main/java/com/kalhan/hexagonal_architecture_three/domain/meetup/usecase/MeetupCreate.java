package com.kalhan.hexagonal_architecture_three.domain.meetup.usecase;

import com.kalhan.hexagonal_architecture_three.domain.common.model.UseCase;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


public class MeetupCreate implements UseCase {
    private String name;
    private String website;
    private BigDecimal price;
    private LocalDateTime eventDate;

    public MeetupCreate(String name, String website, BigDecimal price, LocalDateTime eventDate) {
        this.name = name;
        this.website = website;
        this.price = price;
        this.eventDate = eventDate;
    }

    private MeetupCreate(Builder builder) {
        setName(builder.name);
        setWebsite(builder.website);
        setPrice(builder.price);
        setEventDate(builder.eventDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetupCreate that = (MeetupCreate) o;
        return Objects.equals(name, that.name) && Objects.equals(website, that.website) && Objects.equals(price, that.price) && Objects.equals(eventDate, that.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, website, price, eventDate);
    }


    public static final class Builder {
        private String name;
        private String website;
        private BigDecimal price;
        private LocalDateTime eventDate;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder website(String val) {
            website = val;
            return this;
        }

        public Builder price(BigDecimal val) {
            price = val;
            return this;
        }

        public Builder eventDate(LocalDateTime val) {
            eventDate = val;
            return this;
        }

        public MeetupCreate build() {
            return new MeetupCreate(this);
        }
    }
}
