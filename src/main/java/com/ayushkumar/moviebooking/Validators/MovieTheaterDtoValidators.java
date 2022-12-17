package com.ayushkumar.moviebooking.Validators;

import com.ayushkumar.moviebooking.Dtos.MovieTheaterDto;
import com.ayushkumar.moviebooking.Exception.InvalidMovieTheaterRequestBodyException;

public class MovieTheaterDtoValidators {
    public static boolean isValid(MovieTheaterDto movieTheaterDto) throws InvalidMovieTheaterRequestBodyException {
        if(movieTheaterDto.getMovieId()<=0)
            throw new InvalidMovieTheaterRequestBodyException("Movie ID is Invalid");
        else if(movieTheaterDto.getTheaterId()<=0)
            throw new InvalidMovieTheaterRequestBodyException("Theater ID is Invalid");
        return true;
    }
}
