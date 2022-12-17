package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Exception.BookingDetailsNotFoundException;
import com.ayushkumar.moviebooking.Entity.Booking;

import java.util.List;

public interface BookingServices {
    public Booking acceptBookingDetails(Booking booking);
    public Booking getBookingDetailsById(int id) throws BookingDetailsNotFoundException;
    public Booking updateBookingDetails(int id,Booking booking) throws BookingDetailsNotFoundException;
    public boolean deleteBooking(int id);
    public List<Booking> getAllBookingDetails();
}
