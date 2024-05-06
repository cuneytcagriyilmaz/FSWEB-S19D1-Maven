package com.workintech.s18d2.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(FruitException exception) {
        FruitErrorResponse fruitErrorResponse = new FruitErrorResponse(exception.getHttpStatus().value(), exception.getMessage(), LocalDateTime.now());
        log.error("Fruit exception occured: ", exception);
        return new ResponseEntity<>(fruitErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(HandlerMethodValidationException exception) {
        FruitErrorResponse fruitErrorResponse = new FruitErrorResponse(HttpStatus.BAD_REQUEST.value(),
                Arrays.stream(Objects.requireNonNull(exception.getDetailMessageArguments())).findFirst().isPresent() ? Arrays.stream(exception.getDetailMessageArguments()).findFirst().get().toString() : "hata oluştu", LocalDateTime.now());
        log.error("Plant exception occured: ", exception);
        return new ResponseEntity<>(fruitErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(Exception exception) {
        FruitErrorResponse fruitErrorResponse = new FruitErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), LocalDateTime.now());
        log.error("Plant exception occured: ", exception);
        return new ResponseEntity<>(fruitErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
