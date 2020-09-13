package com.thoughtworks.capability.gtb.restfulapidesign.Exception;

import com.thoughtworks.capability.gtb.restfulapidesign.Common.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = GenderNotFoundException.class)
    public ResponseEntity<ErrorResult> genderNotFoundHandler(GenderNotFoundException ex) {
        String message = ex.getMessage();
        ErrorResult errorResult = ErrorResult.builder().code(HttpStatus.NOT_FOUND.value())
                .message(message).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }
}
