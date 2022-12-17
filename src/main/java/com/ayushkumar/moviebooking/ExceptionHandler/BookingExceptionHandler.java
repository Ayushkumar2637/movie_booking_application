package com.ayushkumar.moviebooking.ExceptionHandler;

import com.ayushkumar.moviebooking.Exception.BookingDetailsNotFoundException;
import com.ayushkumar.moviebooking.Exception.InvalidBookingRequestBodyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookingExceptionHandler {

    @ExceptionHandler(BookingDetailsNotFoundException.class)
    public ResponseEntity handleBookingDetailsNotFoundException(){
        return new ResponseEntity("Invalid Booking ID is Passed", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidBookingRequestBodyException.class)
    public ResponseEntity handleInvalidBookingRequestBodyException(){
        return new ResponseEntity("Invalid Booking data is passed",HttpStatus.BAD_REQUEST);
    }

}
