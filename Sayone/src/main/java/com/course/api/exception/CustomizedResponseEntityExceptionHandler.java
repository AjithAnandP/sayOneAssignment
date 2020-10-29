package com.course.api.exception;


import com.course.api.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundExceptionHandler.class)
    public final ResponseEntity handleNotFountExceptions(Exception ex, WebRequest request) {
        ErrorDto response=new ErrorDto();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setError(ex.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestExceptionHandler.class)
    public final ResponseEntity handleBadRequestExceptions(Exception ex, WebRequest request) {
        ErrorDto response=new ErrorDto();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setError(ex.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HandleUnexpectedException.class)
    public final ResponseEntity handleUnExpectedException(Exception ex, WebRequest request) {
        ErrorDto response=new ErrorDto();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setError(ex.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityAlreadyExistsExceptionHandler.class)
    public final ResponseEntity entityAlreadyExistsException(Exception ex, WebRequest request) {
        ErrorDto response=new ErrorDto();
        response.setCode(HttpStatus.CONFLICT.value());
        response.setError(ex.getMessage());
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }

}