package com.kalhan.hexagonal_architecture_three.domain.account.model;

import java.util.Objects;

public class Account {
    private Long id;
    private String name;
    private String surname;

    public Account(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    private Account(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setSurname(builder.surname);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(name, account.name) && Objects.equals(surname, account.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String surname;

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

        public Builder surname(String val) {
            surname = val;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
