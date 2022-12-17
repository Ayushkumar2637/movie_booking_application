package com.ayushkumar.moviebooking.ExceptionHandler;

import com.ayushkumar.moviebooking.Exception.UserTypeDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserTypeExceptionHandler {

    @ExceptionHandler(UserTypeDetailsNotFoundException.class)
    public ResponseEntity handleUserTypeDetailsNotFoundException(){
        return new ResponseEntity("Invalid UserType ID is Passed", HttpStatus.BAD_REQUEST);
    }

}
