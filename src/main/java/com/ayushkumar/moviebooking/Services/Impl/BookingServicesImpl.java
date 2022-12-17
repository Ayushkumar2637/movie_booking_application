package com.ayushkumar.moviebooking.Services.Impl;

import com.ayushkumar.moviebooking.Exception.BookingDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.BookingServices;
import com.ayushkumar.moviebooking.Daos.BookingDao;
import com.ayushkumar.moviebooking.Entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServicesImpl implements BookingServices {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public Booking acceptBookingDetails(Booking booking) {
        return bookingDao.save(booking);
    }

    @Override
    public Booking getBookingDetailsById(int id) throws BookingDetailsNotFoundException {
        Booking booking=bookingDao.findById(id).orElseThrow(()
                ->new BookingDetailsNotFoundException("Booking details not found for the booking id : "+id));
        return booking;
    }

    @Override
    public Booking updateBookingDetails(int id, Booking booking) throws BookingDetailsNotFoundException {
        // fetch
        Booking fetchedbooking=bookingDao.findById(id).orElseThrow(()
                ->new BookingDetailsNotFoundException("Booking details not found for the booking id : "+id));
        // update
        if(booking.getBookingDate()!=null)
            fetchedbooking.setBookingDate(booking.getBookingDate());
        if(booking.getMovieTheater()!=null)
            fetchedbooking.setMovieTheater(booking.getMovieTheater());
        if(booking.getNoOfSeats()>0)
            fetchedbooking.setNoOfSeats(booking.getNoOfSeats());
        if(booking.getUsers()!=null)
            fetchedbooking.setUsers(booking.getUsers());
        // save
        return bookingDao.save(fetchedbooking);
    }

    @Override
    public boolean deleteBooking(int id) {
        bookingDao.deleteById(id);
        return true;
    }

    @Override
    public List<Booking> getAllBookingDetails() {
        return bookingDao.findAll();
    }
}
