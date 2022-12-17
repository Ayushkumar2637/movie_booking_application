package com.ayushkumar.moviebooking.ExceptionHandler;

import com.ayushkumar.moviebooking.Exception.InvaidStatusRequestBodyException;
import com.ayushkumar.moviebooking.Exception.StatusDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StatusExceptionHandler {

    @ExceptionHandler(StatusDetailsNotFoundException.class)
    public ResponseEntity handleStatusDetailsNotFoundException(){
        return new ResponseEntity("Invalid Status Details Passed", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvaidStatusRequestBodyException.class)
    public ResponseEntity handleInvaidStatusRequestBodyException(){
        return new ResponseEntity("Invalid Status data is passed",HttpStatus.BAD_REQUEST);
    }

}
