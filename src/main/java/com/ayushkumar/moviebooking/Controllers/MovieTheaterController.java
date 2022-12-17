package com.ayushkumar.moviebooking.Controllers;

import com.ayushkumar.moviebooking.Dtos.MovieTheaterDto;
import com.ayushkumar.moviebooking.Entity.Booking;
import com.ayushkumar.moviebooking.Entity.MovieTheater;
import com.ayushkumar.moviebooking.Exception.*;
import com.ayushkumar.moviebooking.Services.BookingServices;
import com.ayushkumar.moviebooking.Services.MovieServices;
import com.ayushkumar.moviebooking.Services.MovieTheaterServices;
import com.ayushkumar.moviebooking.Services.TheaterServices;
import com.ayushkumar.moviebooking.Validators.MovieTheaterDtoValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movietheaters")
public class MovieTheaterController {

    @Autowired
    private MovieTheaterServices movieTheaterServices;
    @Autowired
    private MovieServices movieServices;
    @Autowired
    private TheaterServices theaterServices;
    @Autowired
    private BookingServices bookingServices;

    @PostMapping
    public ResponseEntity createMovieTheater(@RequestBody MovieTheaterDto movieTheaterDto) throws TheaterDetailsNotFoundException, BookingDetailsNotFoundException, MovieDetailsNotFoundException, InvalidMovieTheaterRequestBodyException {
        MovieTheaterDtoValidators.isValid(movieTheaterDto);
        MovieTheater movieTheater=convertToMovieTheater(movieTheaterDto);
        MovieTheater savedMovieTheater=movieTheaterServices.acceptMovieTheaterDetails(movieTheater);
        MovieTheaterDto movieTheaterDto1=convertToMovieTheaterDto(savedMovieTheater);
        return new ResponseEntity(movieTheaterDto1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMovieTheaterById(@PathVariable("id") int id) throws MovieTheaterDetailsNotFoundException {
        MovieTheater fetchedMovieTheater=movieTheaterServices.getMovieTheaterBasedOnId(id);
        MovieTheaterDto movieTheaterDto=convertToMovieTheaterDto(fetchedMovieTheater);
        return new ResponseEntity(movieTheaterDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllMovieTheater(){
        List<MovieTheater> movieTheaters=movieTheaterServices.getAllMovieTheaterDetails();
        List<MovieTheaterDto> movieTheatersDtos=new ArrayList<>();
        for(MovieTheater movieTheater : movieTheaters)
            movieTheatersDtos.add(convertToMovieTheaterDto(movieTheater));
        return new ResponseEntity(movieTheatersDtos,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMovieTheater(@PathVariable("id") int id,@RequestBody MovieTheaterDto movieTheaterDto) throws TheaterDetailsNotFoundException, BookingDetailsNotFoundException, MovieDetailsNotFoundException, MovieTheaterDetailsNotFoundException {
        MovieTheater movieTheater=convertToMovieTheater(movieTheaterDto);
        MovieTheater updatedMovieTheater=movieTheaterServices.updateMovieTheaterDetails(id,movieTheater);
        MovieTheaterDto movieTheaterDto1=convertToMovieTheaterDto(updatedMovieTheater);
        return new ResponseEntity(movieTheaterDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovieTheater(@PathVariable("id") int id){
        return new ResponseEntity(movieTheaterServices.deleteMovieTheater(id),HttpStatus.OK);
    }

    private MovieTheaterDto convertToMovieTheaterDto(MovieTheater savedMovieTheater) {
        MovieTheaterDto movieTheaterDto=new MovieTheaterDto(savedMovieTheater.getMovieTheaterId());
        if(savedMovieTheater.getMovie()!=null)
            movieTheaterDto.setMovieId(savedMovieTheater.getMovie().getMovieId());
        if(savedMovieTheater.getTheater()!=null)
            movieTheaterDto.setTheaterId(savedMovieTheater.getTheater().getTheaterId());
        if(savedMovieTheater.getBooking()!=null){
            List<Integer> list=new ArrayList<>();
            for(Booking booking : savedMovieTheater.getBooking()){
                list.add(booking.getBookingId());
            }
            movieTheaterDto.setBookingsId(list);
        }
        return movieTheaterDto;
    }

    private MovieTheater convertToMovieTheater(MovieTheaterDto movieTheaterDto) throws MovieDetailsNotFoundException, TheaterDetailsNotFoundException, BookingDetailsNotFoundException {
        MovieTheater movieTheater=new MovieTheater(movieTheaterDto.getMovieTheaterId());
        if(movieTheaterDto.getMovieId()!=0)
            movieTheater.setMovie(movieServices.getMovieBasedOnId(movieTheaterDto.getMovieId()));
        if(movieTheaterDto.getTheaterId()!=0)
            movieTheater.setTheater(theaterServices.getTheaterDetailsById(movieTheaterDto.getTheaterId()));
        if(movieTheaterDto.getBookingsId()!=null){
            List<Booking> bookings=new ArrayList<>();
            List<Integer> bookingsId=movieTheaterDto.getBookingsId();
            for(Integer i : bookingsId){
                bookings.add(bookingServices.getBookingDetailsById(i));
            }
            movieTheater.setBooking(bookings);
        }
        return movieTheater;
    }

}
