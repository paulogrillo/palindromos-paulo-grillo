package com.bradesco.app.exception.handler;

import com.bradesco.app.dto.ResponseError;
import com.bradesco.app.exception.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends GenericHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> businessException(final Exception exception){
        return buildResponse(HttpStatus.BAD_REQUEST, exception);
    }

}
