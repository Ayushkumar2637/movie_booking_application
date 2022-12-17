package com.ayushkumar.moviebooking.Validators;

import com.ayushkumar.moviebooking.Dtos.BookingDto;
import com.ayushkumar.moviebooking.Exception.InvalidBookingRequestBodyException;

public class BookingDtoValidators {
    public static boolean isValid(BookingDto bookingDto) throws InvalidBookingRequestBodyException {
        if(bookingDto.getBookingDate()==null)
            throw new InvalidBookingRequestBodyException("Booking date is empty");
        else if(bookingDto.getNoOfSeats()<=0)
            throw new InvalidBookingRequestBodyException("Number of Seats is Invalid");
        else if(bookingDto.getMovieTheaterId()<=0)
            throw new InvalidBookingRequestBodyException("Movie Theater ID is Invalid");
        else if(bookingDto.getUsersId()<=0)
            throw new InvalidBookingRequestBodyException("User ID is Invalid");
        return true;
    }
}
