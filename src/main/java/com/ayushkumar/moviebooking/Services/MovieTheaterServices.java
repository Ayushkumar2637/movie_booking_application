package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Entity.MovieTheater;
import com.ayushkumar.moviebooking.Exception.MovieTheaterDetailsNotFoundException;

import java.util.List;

public interface MovieTheaterServices {
    public MovieTheater acceptMovieTheaterDetails(MovieTheater movieTheater);
    public MovieTheater getMovieTheaterBasedOnId(int id) throws MovieTheaterDetailsNotFoundException;
    public MovieTheater updateMovieTheaterDetails(int id,MovieTheater movieTheater) throws MovieTheaterDetailsNotFoundException;
    public boolean deleteMovieTheater(int id);
    public List<MovieTheater> getAllMovieTheaterDetails();
}
