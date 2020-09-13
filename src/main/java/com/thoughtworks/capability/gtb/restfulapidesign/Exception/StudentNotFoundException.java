package com.thoughtworks.capability.gtb.restfulapidesign.Exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
