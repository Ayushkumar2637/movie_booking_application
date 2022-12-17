package com.ayushkumar.moviebooking.ExceptionHandler;

import com.ayushkumar.moviebooking.Exception.InvalidUsersRequestBodyException;
import com.ayushkumar.moviebooking.Exception.UserDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsersExceptionHandler {

    @ExceptionHandler(UserDetailsNotFoundException.class)
    public ResponseEntity handleUserDetailsNotFoundException(){
        return new ResponseEntity("Invalid User ID is Passed", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidUsersRequestBodyException.class)
    public ResponseEntity handleInvalidUsersRequestBodyException(){
        return new ResponseEntity("Invalid User data is passed",HttpStatus.BAD_REQUEST);
    }

}
