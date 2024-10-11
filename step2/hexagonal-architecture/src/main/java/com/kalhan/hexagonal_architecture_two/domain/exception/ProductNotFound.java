package com.kalhan.hexagonal_architecture_two.domain.exception;

public class ProductNotFound extends RuntimeException {

    public ProductNotFound(String message) {
        super(message);
    }

}
