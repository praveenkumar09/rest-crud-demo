package com.praveen.springguru.rest_crud_demo.error;

import com.praveen.springguru.rest_crud_demo.error.exception.NotFoundException;
import com.praveen.springguru.rest_crud_demo.error.pojo.ErrorResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * The GlobalExceptionHandler class is a controller advice that handles exceptions
 * thrown by the application. It provides exception handling for NotFoundException
 * and BadRequestException.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * This method handles the NotFoundException and generates a custom ErrorResponse
     * object with the appropriate status code, message, and timestamp. It returns a
     * ResponseEntity containing the ErrorResponse and the corresponding HTTP status
     * code.
     *
     * @param ex The NotFoundException that is thrown when the requested resource is not found
     * @return A ResponseEntity object containing the custom ErrorResponse and the
     *         corresponding HTTP status code
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
       ErrorResponse errorResponse = new ErrorResponse();
       errorResponse.setMessage(ex.getMessage());
       errorResponse.setCode(HttpStatus.NOT_FOUND.value());
       errorResponse.setTimestamp(System.currentTimeMillis());
       return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * This method handles the BadRequestException and generates a custom ErrorResponse
     * object with the appropriate status code, message, and timestamp. It returns a
     * ResponseEntity containing the ErrorResponse and the corresponding HTTP status
     * code.
     *
     * @param ex The BadRequestException that is thrown when the request is malformed or
     *            invalid
     * @return A ResponseEntity object containing the custom ErrorResponse and the
     *         corresponding HTTP status code
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Bad Request");
        errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCommonNotFoundException(NoResourceFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Resource Not Found");
        errorResponse.setCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
