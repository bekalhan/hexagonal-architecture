package com.kalhan.hexagonal_architecture_three.infrastructure.common.customizedexception.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketApiBusinessException extends RuntimeException {

    private final String key;
    private final String[] args;

    public TicketApiBusinessException(String key) {
        super(key);
        this.key = key;
        args = new String[0];
    }

    public TicketApiBusinessException(String key, String... args) {
        super(key);
        this.key = key;
        this.args = args;
    }
}
