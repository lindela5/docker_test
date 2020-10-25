package com.innowise.darya.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThereIsNoSuchCustomerException.class)
    protected ResponseEntity<CustomerException> handleThereIsNoSuchCustomerException() {
        return new ResponseEntity<>(new CustomerException("There is no such customer"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class CustomerException {
        private String message;
    }
}

