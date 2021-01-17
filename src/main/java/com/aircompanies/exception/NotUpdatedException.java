package com.aircompanies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotUpdatedException extends RuntimeException {

    public NotUpdatedException() {
        super();
    }

    public NotUpdatedException(String message) {
        super(message);
    }
}