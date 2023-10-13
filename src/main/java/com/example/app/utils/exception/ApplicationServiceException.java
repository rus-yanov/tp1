package com.example.app.utils.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationServiceException extends RuntimeException {

    private HttpStatus httpStatus;
    private String methodName;

    public ApplicationServiceException(String methodName, String message, HttpStatus httpStatus) {
        super(message);
        this.methodName = methodName;
        this.httpStatus = httpStatus;
    }
}
