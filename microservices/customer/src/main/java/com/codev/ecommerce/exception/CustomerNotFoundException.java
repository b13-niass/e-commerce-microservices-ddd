package com.codev.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends RuntimeException{
    private String msg;
    public CustomerNotFoundException(String msg) {
        super(msg);
    }
}
