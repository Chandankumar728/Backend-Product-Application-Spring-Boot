
package com.bitsnbuytes.product.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class CategoryNotFoundExist extends RuntimeException {
    public CategoryNotFoundExist(String message) {
        super(message);
    }
}
