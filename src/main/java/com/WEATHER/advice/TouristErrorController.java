package com.WEATHER.advice;

import com.WEATHER.exception.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice//For global exception handling
public class TouristErrorController
{
    @ExceptionHandler(TouristNotFoundException.class)//Explicit handler
    public ResponseEntity<ErrorDetails> touristHandler(TouristNotFoundException e)
    {
        ErrorDetails error = new ErrorDetails ("404 Not Found",e.getMessage (), LocalDateTime.now ());
        System.out.println ("*Custom Exception Handled*");
        return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)//General handler
    public ResponseEntity<ErrorDetails> globalHandler(Exception e)
    {
        ErrorDetails error = new ErrorDetails ("404 Not Found",e.getMessage (), LocalDateTime.now ());
        System.out.println ("* General Exception Handled*");
        return new ResponseEntity<> (error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
