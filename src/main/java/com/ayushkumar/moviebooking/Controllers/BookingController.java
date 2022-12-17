package com.ayushkumar.moviebooking.Controllers;

import com.ayushkumar.moviebooking.Dtos.BookingDto;
import com.ayushkumar.moviebooking.Entity.Booking;
import com.ayushkumar.moviebooking.Exception.BookingDetailsNotFoundException;
import com.ayushkumar.moviebooking.Exception.InvalidBookingRequestBodyException;
import com.ayushkumar.moviebooking.Exception.MovieTheaterDetailsNotFoundException;
import com.ayushkumar.moviebooking.Exception.UserDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.BookingServices;
import com.ayushkumar.moviebooking.Services.MovieTheaterServices;

import com.ayushkumar.moviebooking.Services.UsersServices;
import com.ayushkumar.moviebooking.Validators.BookingDtoValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingServices bookingServices;
    @Autowired
    private MovieTheaterServices movieTheaterServices;
    @Autowired
    private UsersServices usersServices;

    @PostMapping
    public ResponseEntity createBooking(@RequestBody BookingDto bookingDto) throws UserDetailsNotFoundException, MovieTheaterDetailsNotFoundException, InvalidBookingRequestBodyException {
        BookingDtoValidators.isValid(bookingDto);
        Booking booking=convertToBooking(bookingDto);
        Booking savedBooking= bookingServices.acceptBookingDetails(booking);
        BookingDto bookingDto1=convertToBookingDto(savedBooking);
        return new ResponseEntity(bookingDto1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookingById(@PathVariable("id") int id) throws BookingDetailsNotFoundException {
        Booking fetchedBooking=bookingServices.getBookingDetailsById(id);
        BookingDto bookingDto=convertToBookingDto(fetchedBooking);
        return new ResponseEntity(bookingDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllBooking(){
        List<Booking> bookings=bookingServices.getAllBookingDetails();
        List<BookingDto> bookingsDtos=new ArrayList<>();
        for(Booking booking : bookings)
            bookingsDtos.add(convertToBookingDto(booking));
        return new ResponseEntity(bookingsDtos,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBooking(@PathVariable("id") int id,@RequestBody BookingDto bookingDto) throws UserDetailsNotFoundException, MovieTheaterDetailsNotFoundException, BookingDetailsNotFoundException {
        Booking booking=convertToBooking(bookingDto);
        Booking updatedBooking=bookingServices.updateBookingDetails(id,booking);
        BookingDto bookingDto1=convertToBookingDto(updatedBooking);
        return new ResponseEntity(bookingDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBooking(@PathVariable("id") int id){
        return new ResponseEntity(bookingServices.deleteBooking(id),HttpStatus.OK);
    }

    private BookingDto convertToBookingDto(Booking savedBooking) {
        BookingDto bookingDto=new BookingDto(savedBooking.getBookingId(),savedBooking.getBookingDate(),savedBooking.getNoOfSeats());
        if(savedBooking.getMovieTheater()!=null)
            bookingDto.setMovieTheaterId(savedBooking.getMovieTheater().getMovieTheaterId());
        if(savedBooking.getUsers()!=null)
            bookingDto.setUsersId(savedBooking.getUsers().getUserId());
        return bookingDto;
    }

    private Booking convertToBooking(BookingDto bookingDto) throws MovieTheaterDetailsNotFoundException, UserDetailsNotFoundException {
        Booking booking=new Booking(bookingDto.getBookingId(),bookingDto.getBookingDate(),bookingDto.getNoOfSeats());
        if(bookingDto.getMovieTheaterId()!=0)
            booking.setMovieTheater(movieTheaterServices.getMovieTheaterBasedOnId(bookingDto.getMovieTheaterId()));
        if(bookingDto.getUsersId()!=0)
            booking.setUsers(usersServices.getUserDetailsById(bookingDto.getUsersId()));
        return booking;
    }

}
