package com.thoughtworks.capability.gtb.restfulapidesign.Common;

import com.thoughtworks.capability.gtb.restfulapidesign.Common.ErrorResult;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.GenderNotFoundException;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {GenderNotFoundException.class, StudentNotFoundException.class})
    public ResponseEntity<ErrorResult> genderNotFoundHandler(Exception ex) {
        String message = ex.getMessage();
        ErrorResult errorResult = ErrorResult.builder().code(HttpStatus.NOT_FOUND.value())
                .message(message).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }
}
