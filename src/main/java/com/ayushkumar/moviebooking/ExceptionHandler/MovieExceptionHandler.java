package com.ayushkumar.moviebooking.ExceptionHandler;

import com.ayushkumar.moviebooking.Exception.InvalidMovieRequestBodyException;
import com.ayushkumar.moviebooking.Exception.MovieDetailsNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// AOP -> Aspect Oriented Programing
// if we need to write some code again & again then we just write that code in a single place & give hind to program to
// use the code from the place where the code is written

@ControllerAdvice  // Any time the controller class throw particular type of exception these class handle the exception
public class MovieExceptionHandler {

    @ExceptionHandler(MovieDetailsNotFoundException.class)
    public ResponseEntity handleMovieDetailsNotFoundException(){
        return new ResponseEntity("Invalid Movie Details Passed", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidMovieRequestBodyException.class)
    public ResponseEntity handleInvalidMovieRequestBodyException(){
        return new ResponseEntity("Invalid movie data is passed",HttpStatus.BAD_REQUEST);
    }

    // This handle for all the delete mapping
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity handleExceptionForAllDeleteMethod(){
        return new ResponseEntity("Invalid ID",HttpStatus.BAD_REQUEST);
    }

//    This is not working
//    @Bean
//    @ExceptionHandler(RequestRejectedException.class)
//    public ResponseEntity handleRequestRejectedException(){
//        return new ResponseEntity("Your request is rejected",HttpStatus.BAD_REQUEST);
//    }

}
