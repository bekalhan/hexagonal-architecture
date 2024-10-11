package com.kalhan.hexagonal_architecture_three.infrastructure.common.rest;


public class ErrorResponse {

    private String errorCode;
    private String errorDescription;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}