package com.codev.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
    private final String msg;
    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
