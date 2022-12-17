package com.ayushkumar.moviebooking.ExceptionHandler;

import com.ayushkumar.moviebooking.Exception.InvalidLanguageRequestBodyException;
import com.ayushkumar.moviebooking.Exception.LanguageDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LanguageExceptionHandler {

    @ExceptionHandler(LanguageDetailsNotFoundException.class)
    public ResponseEntity handleLanguageDetailsNotFoundException(){
        return new ResponseEntity("Invalid Language Details Passed", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidLanguageRequestBodyException.class)
    public ResponseEntity handleInvalidLanguageRequestBodyException(){
        return new ResponseEntity("Invalid Language data is passed",HttpStatus.BAD_REQUEST);
    }

}
