package com.innowise.darya.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PublishingHouseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchException.class)
    protected ResponseEntity<PublishingHouseException> handleThereIsNoSuchPublishingHouseException() {
        return new ResponseEntity<>(new PublishingHouseException("There is no such publishing house"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class PublishingHouseException {
        private String message;
    }
}