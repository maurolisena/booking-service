package com.mlisena.booking.exception.handler;

import com.mlisena.booking.exception.common.ErrorResponse;
import com.mlisena.booking.exception.common.NotFoundException;
import org.apache.commons.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(NotFoundException ex, WebRequest request) {
        Log logger = org.apache.commons.logging.LogFactory.getLog(GlobalExceptionHandler.class);
        logger.error("Global Exception Handler -> Product not found: {}", ex);
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        ErrorResponse errorResponse = ErrorResponse.create(ex, HttpStatus.NOT_FOUND, path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
