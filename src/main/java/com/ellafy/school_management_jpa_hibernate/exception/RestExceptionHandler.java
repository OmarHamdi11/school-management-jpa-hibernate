package com.ellafy.school_management_jpa_hibernate.exception;

import com.ellafy.school_management_jpa_hibernate.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception exception){
        System.out.println("Handle Exception CALLED");
        ApiResponse<String> apiResponse = new ApiResponse<>(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis(),
                null);

        return new ResponseEntity<>(apiResponse , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleNotFoundException(NotFoundException notFoundException){
        System.out.println("HandleNotFound Exception CALLED");
        ApiResponse<String> apiResponse = new ApiResponse<>(
                HttpStatus.NOT_FOUND.value(),
                notFoundException.getMessage(),
                System.currentTimeMillis(),
                null);

        return new ResponseEntity<>(apiResponse , HttpStatus.NOT_FOUND);
    }
}
