package com.bradesco.app.exception.handler;

import com.bradesco.app.dto.ResponseError;
import com.bradesco.app.dto.ResponseErrorErrors;
import com.bradesco.app.exception.BaseException;
import com.bradesco.app.exception.ErrorCodeSupplier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

public class GenericHandler {

    protected ResponseEntity<ResponseError> buildResponse(HttpStatus status, BaseException exception) {
        return buildResponse(status, exception.getErrorCode(), exception.getMessage());
    }

    protected ResponseEntity<ResponseError> buildResponse(HttpStatus status, ErrorCodeSupplier errorCode) {
        return buildResponse(status, errorCode, errorCode.getMessage());
    }

    protected ResponseEntity<ResponseError> buildResponse(HttpStatus status, ErrorCodeSupplier errorCode, String message) {
        final List<ResponseErrorErrors> erorList = Collections.singletonList(new ResponseErrorErrors()
                .code(errorCode.getCode())
                .title(status.getReasonPhrase())
                .details(message));
        return buildResponse(status, erorList);

    }

    protected ResponseEntity<ResponseError> buildResponse(HttpStatus status, List<ResponseErrorErrors> errorsList) {
        return new ResponseEntity<>(new ResponseError()
                .errors(errorsList), status);
    }

}
