package com.aysekoc.projecqrs.core.exception.type;


import java.util.List;

public class ValidationException extends RuntimeException{
    private List<String> errors;

    public ValidationException(List<String> errors){
        this.errors = errors;
    }
}
