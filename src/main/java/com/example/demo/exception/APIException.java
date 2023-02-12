package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record APIException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
}