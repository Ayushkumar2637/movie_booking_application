package com.ayushkumar.moviebooking.Services.Impl;

import com.ayushkumar.moviebooking.Exception.MovieDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.MovieServices;
import com.ayushkumar.moviebooking.Daos.MovieDao;
import com.ayushkumar.moviebooking.Entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServicesImpl implements MovieServices {

    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieBasedOnId(int id) throws MovieDetailsNotFoundException{
        Movie movie=movieDao.findById(id).orElseThrow(()->
                new MovieDetailsNotFoundException("Movie details not found for the movie id : "+id));
        return movie;
    }

    @Override
    public List<Movie> getMovieBasedOnName(String name) throws MovieDetailsNotFoundException{
        List<Movie> movie=movieDao.findByMovieNameIgnoreCase(name);
        if(movie.isEmpty())
            throw new MovieDetailsNotFoundException("Movie details not found for the movie name : "+name);
        return movie;
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException {
        // Fetch movie
        Movie fetchedMovie=movieDao.findById(id).orElseThrow(()->
                new MovieDetailsNotFoundException("Movie details not found for the movie id : "+id));
        // Update movie
        if(movie.getMovieName()!=null)
            fetchedMovie.setMovieName(movie.getMovieName());
        if(movie.getMovieDescription()!=null)
            fetchedMovie.setMovieDescription(movie.getMovieDescription());
        if(movie.getReleaseDate()!=null)
            fetchedMovie.setReleaseDate(movie.getReleaseDate());
        if(movie.getDuration()>0)
            fetchedMovie.setDuration(movie.getDuration());
        if(movie.getCoverPhotoUrl()!=null)
            fetchedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        if(movie.getTrailerUrl()!=null)
            fetchedMovie.setTrailerUrl(movie.getTrailerUrl());
        if(movie.getStatus()!=null)
            fetchedMovie.setStatus(movie.getStatus());
        // Save in DB
        return movieDao.save(fetchedMovie);
    }

    @Override
    public boolean deleteMovie(int id) {
        movieDao.deleteById(id);
        return true;
    }

    @Override
    public List<Movie> getAllMovieDetails() {
        return movieDao.findAll();
    }
}
