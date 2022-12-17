package com.ayushkumar.moviebooking.Services.Impl;

import com.ayushkumar.moviebooking.Daos.MovieTheaterDao;
import com.ayushkumar.moviebooking.Entity.MovieTheater;
import com.ayushkumar.moviebooking.Exception.MovieTheaterDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.MovieTheaterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTheaterServicesImpl implements MovieTheaterServices {

    @Autowired
    private MovieTheaterDao movieTheaterDao;

    @Override
    public MovieTheater acceptMovieTheaterDetails(MovieTheater movieTheater) {
        return movieTheaterDao.save(movieTheater);
    }

    @Override
    public MovieTheater getMovieTheaterBasedOnId(int id) throws MovieTheaterDetailsNotFoundException {
        MovieTheater movieTheater=movieTheaterDao.findById(id).orElseThrow(()->
                new MovieTheaterDetailsNotFoundException("MovieTheater not found for the movieTheater id : "+id));
        return movieTheater;
    }

    @Override
    public MovieTheater updateMovieTheaterDetails(int id, MovieTheater movieTheater) throws MovieTheaterDetailsNotFoundException {
        MovieTheater fetchedMovieTheater=movieTheaterDao.findById(id).orElseThrow(()->
                new MovieTheaterDetailsNotFoundException("MovieTheater not found for the movieTheater id : "+id));

        if(movieTheater.getMovie()!=null)
            fetchedMovieTheater.setMovie(movieTheater.getMovie());
        if(movieTheater.getTheater()!=null)
            fetchedMovieTheater.setTheater(movieTheater.getTheater());
        if(movieTheater.getBooking()!=null)
            fetchedMovieTheater.setBooking(movieTheater.getBooking());

        return movieTheaterDao.save(fetchedMovieTheater);
    }

    @Override
    public boolean deleteMovieTheater(int id) {
        movieTheaterDao.deleteById(id);
        return true;
    }

    @Override
    public List<MovieTheater> getAllMovieTheaterDetails() {
        return movieTheaterDao.findAll();
    }
}
