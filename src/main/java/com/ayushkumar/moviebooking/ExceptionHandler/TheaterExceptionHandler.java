package com.ayushkumar.moviebooking.ExceptionHandler;

import com.ayushkumar.moviebooking.Exception.InvalidTheaterRequestBodyException;
import com.ayushkumar.moviebooking.Exception.TheaterDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TheaterExceptionHandler {

    @ExceptionHandler(TheaterDetailsNotFoundException.class)
    public ResponseEntity handleTheaterDetailsNotFoundException(){
        return new ResponseEntity("Invalid Theater Details Passed", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidTheaterRequestBodyException.class)
    public ResponseEntity handleInvalidTheaterRequestBodyException(){
        return new ResponseEntity("Invalid Theater data is passed",HttpStatus.BAD_REQUEST);
    }

}
