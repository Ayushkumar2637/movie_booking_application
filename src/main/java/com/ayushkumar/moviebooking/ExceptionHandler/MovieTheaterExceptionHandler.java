package com.ayushkumar.moviebooking.ExceptionHandler;

import com.ayushkumar.moviebooking.Exception.InvalidMovieTheaterRequestBodyException;
import com.ayushkumar.moviebooking.Exception.MovieTheaterDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieTheaterExceptionHandler {

    @ExceptionHandler(MovieTheaterDetailsNotFoundException.class)
    public ResponseEntity handleMovieTheaterDetailsNotFoundException(){
        return new ResponseEntity("Invalid MovieTheater ID is Passed", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidMovieTheaterRequestBodyException.class)
    public ResponseEntity handleInvalidMovieTheaterRequestBodyException(){
        return new ResponseEntity("Invalid MovieTheater data is passed",HttpStatus.BAD_REQUEST);
    }

}
