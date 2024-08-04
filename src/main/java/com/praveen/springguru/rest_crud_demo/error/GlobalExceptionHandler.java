package com.praveen.springguru.rest_crud_demo.error;

import com.praveen.springguru.rest_crud_demo.error.exception.NotFoundException;
import com.praveen.springguru.rest_crud_demo.error.pojo.ErrorResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
       ErrorResponse errorResponse = new ErrorResponse();
       errorResponse.setMessage(ex.getMessage());
       errorResponse.setCode(HttpStatus.NOT_FOUND.value());
       errorResponse.setTimestamp(System.currentTimeMillis());
       return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Bad Request");
        errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
