package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = APIRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(APIRequestException apiRequestException){
        var apiException = new APIException(
                apiRequestException.getMessage(),
                apiRequestException,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(NotFoundException apiRequestException){
        var apiException = new APIException(
                apiRequestException.getMessage(),
                apiRequestException,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                apiException,
                HttpStatus.NOT_FOUND
        );
    }
}