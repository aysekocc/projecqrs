package com.aysekoc.projecqrs.core.exception;

import jakarta.xml.bind.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<String> validationException(ValidationException e){
        return new ResponseEntity<>("Validation Exception", HttpStatus.BAD_REQUEST);
    }
}
