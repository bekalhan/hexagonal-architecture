package com.kalhan.hexagonal_architecture_three.domain.meetup.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Meetup {
    private Long id;
    private String name;
    private String website;
    private BigDecimal price;
    private LocalDateTime eventDate;

    public Meetup(Long id, String name, String website, BigDecimal price, LocalDateTime eventDate) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.price = price;
        this.eventDate = eventDate;
    }

    private Meetup(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setWebsite(builder.website);
        setPrice(builder.price);
        setEventDate(builder.eventDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Meetup meetup = (Meetup) o;
        return Objects.equals(id, meetup.id) && Objects.equals(name, meetup.name) && Objects.equals(website, meetup.website) && Objects.equals(price, meetup.price) && Objects.equals(eventDate, meetup.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, website, price, eventDate);
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String website;
        private BigDecimal price;
        private LocalDateTime eventDate;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(Long val) {
            id = val;
            return this;
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

        public Meetup build() {
            return new Meetup(this);
        }
    }
}
