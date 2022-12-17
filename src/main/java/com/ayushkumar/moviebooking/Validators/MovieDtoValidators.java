package com.ayushkumar.moviebooking.Validators;

import com.ayushkumar.moviebooking.Dtos.MovieDto;
import com.ayushkumar.moviebooking.Exception.InvalidMovieRequestBodyException;

public class MovieDtoValidators {
    public static boolean isValid(MovieDto movieDto) throws InvalidMovieRequestBodyException {
        if(movieDto.getMovieName()==null  || movieDto.getMovieName().equals(""))
            throw new InvalidMovieRequestBodyException("Movie name is empty or null");
        else if(movieDto.getMovieDescription()==null || movieDto.getMovieDescription().equals(""))
            throw new InvalidMovieRequestBodyException("Movie description is empty or null");
        else if(movieDto.getReleaseDate()==null)
            throw new InvalidMovieRequestBodyException("Movie release date is empty");
        else if(movieDto.getDuration()<45 || movieDto.getDuration()>180)
            throw new InvalidMovieRequestBodyException("Movie duration is Invalid");
        else if(movieDto.getCoverPhotoUrl()==null || movieDto.getCoverPhotoUrl().equals(""))
            throw new InvalidMovieRequestBodyException("Movie cover photo url is empty or null");
        else if(movieDto.getTrailerUrl()==null || movieDto.getTrailerUrl().equals(""))
            throw new InvalidMovieRequestBodyException("Movie Trailer is empty or null");
        else if(movieDto.getStatusId()<=0)
            throw new InvalidMovieRequestBodyException("Movie status is Invalid");
        return true;
    }
}
