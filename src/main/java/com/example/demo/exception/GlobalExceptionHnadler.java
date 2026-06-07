package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHnadler
{

    @ExceptionHandler(BookNotFoundException.class)


    public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException ex, HttpServletRequest request)
    {
        ErrorResponse errorResponse=new ErrorResponse();

     errorResponse.setTimestamp(LocalDateTime.now());

     errorResponse.setStatus(HttpStatus.NOT_FOUND.value());

     errorResponse.setError(HttpStatus.NOT_FOUND.toString());

     errorResponse.setMessage(ex.getMessage());

     errorResponse.setPath(request.getRequestURI());

     return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex)
    {
        Map<String,String> errors = new HashMap<>();
    ex.getBindingResult()
                .getFieldErrors()
                .forEach((error-> errors.put(
                        error.getField(),error.getDefaultMessage()
                )));

    return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ErrorResponse> handleHandlerMethodException(HandlerMethodValidationException ex,HttpServletRequest request)
    {
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

}
