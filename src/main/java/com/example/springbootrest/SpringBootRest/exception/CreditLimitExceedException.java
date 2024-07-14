package com.example.springbootrest.SpringBootRest.exception;

import org.springframework.http.HttpStatus;

public class CreditLimitExceedException extends RuntimeException {

    private HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public CreditLimitExceedException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
