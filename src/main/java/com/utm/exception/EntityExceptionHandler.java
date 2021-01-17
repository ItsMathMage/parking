package com.utm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class EntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception e, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<Object> handleServiceException(ServiceException e, WebRequest request) {
        final String bodyResponse = "Щось тут не так";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
