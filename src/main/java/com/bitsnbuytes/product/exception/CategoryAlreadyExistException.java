package com.bitsnbuytes.product.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.CONFLICT)
public class CategoryAlreadyExistException extends RuntimeException{
    public CategoryAlreadyExistException(String message){
        super(message);
    }
}
