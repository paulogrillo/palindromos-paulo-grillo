package com.bradesco.app.exception;

import lombok.Getter;

@Getter
public enum ErrorCodeSupplier {

    MATRIX_001("MATRIX_001", "Invalid format JSON."),
    MATRIX_002("MATRIX_002", "The inserted matrix is not a valid matrix"),
    MATRIX_005("MATRIX_005", "Error connection in database");

    private final String code;
    private final String message;

    ErrorCodeSupplier(String code, String message){
        this.code = code;
        this.message = message;
    }
}
