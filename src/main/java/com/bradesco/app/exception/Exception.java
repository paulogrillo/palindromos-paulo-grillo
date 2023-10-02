package com.bradesco.app.exception;

import lombok.Getter;

@Getter
public class Exception extends BaseException {

    public Exception(final ErrorCodeSupplier errorCode){
        super(errorCode);
    }

    public Exception(String errorMessage, final ErrorCodeSupplier errorCode){
        super(errorMessage, errorCode);
    }
}
