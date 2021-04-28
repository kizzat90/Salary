package com.salary.app.controller;

import com.salary.app.util.CustomErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ CustomErrorMessage.class })
    public ResponseEntity<Object> handleSalaryError(CustomErrorMessage ex) {
        return new ResponseEntity<>(ex, new HttpHeaders(), ex.getStatus());
    }
}
