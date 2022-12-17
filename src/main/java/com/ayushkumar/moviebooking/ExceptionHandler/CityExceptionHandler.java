package com.ayushkumar.moviebooking.ExceptionHandler;

import com.ayushkumar.moviebooking.Exception.CityDetailsNotFoundException;
import com.ayushkumar.moviebooking.Exception.InvalidCityRequestBodyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CityExceptionHandler {

    @ExceptionHandler(CityDetailsNotFoundException.class)
    public ResponseEntity handleCityDetailsNotFoundException(){
        return new ResponseEntity("Invalid City Details Passed", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidCityRequestBodyException.class)
    public ResponseEntity handleInvalidCityRequestBodyException(){
        return new ResponseEntity("Invalid City data is passed",HttpStatus.BAD_REQUEST);
    }

}
