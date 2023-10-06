package com.bradesco.app.exception;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {

    protected final ErrorCodeSupplier errorCode;

    protected BaseException(final ErrorCodeSupplier errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    protected BaseException(String errorMessage, final ErrorCodeSupplier errorCode){
        super(errorMessage);
        this.errorCode = errorCode;
    }

}
