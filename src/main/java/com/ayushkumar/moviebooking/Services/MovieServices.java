package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Exception.MovieDetailsNotFoundException;
import com.ayushkumar.moviebooking.Entity.Movie;

import java.util.List;

public interface MovieServices {
    // CRUD operations

    // Help to assign a movie in DB
    public Movie acceptMovieDetails(Movie movie);

    // Help to fetch the movie
    public Movie getMovieBasedOnId(int id) throws MovieDetailsNotFoundException;
    public List<Movie> getMovieBasedOnName(String name) throws MovieDetailsNotFoundException;

    // Help to Update the movie details
    public Movie updateMovieDetails(int id,Movie movie) throws MovieDetailsNotFoundException;

    // Help to delete the movie details
    public boolean deleteMovie(int id);

    // Help to fetch all the movie
    public List<Movie> getAllMovieDetails();

}
