package com.maturalac.maturalacservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.FileNotFoundException;
import java.util.Date;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorResponse> fileNotFoundException(FileNotFoundException e, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(e.getLocalizedMessage(), new Date()),
                HttpStatus.NOT_FOUND);
    }
}
