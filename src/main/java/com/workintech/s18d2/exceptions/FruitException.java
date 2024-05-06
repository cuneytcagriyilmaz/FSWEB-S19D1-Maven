package com.workintech.s18d2.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class FruitException extends RuntimeException {
    private HttpStatus httpStatus;

    public FruitException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
