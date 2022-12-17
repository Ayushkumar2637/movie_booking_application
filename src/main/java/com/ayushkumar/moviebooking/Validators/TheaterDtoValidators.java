package com.ayushkumar.moviebooking.Validators;

import com.ayushkumar.moviebooking.Dtos.TheaterDto;
import com.ayushkumar.moviebooking.Exception.InvalidTheaterRequestBodyException;

public class TheaterDtoValidators {
    public static boolean isValid(TheaterDto theaterDto) throws InvalidTheaterRequestBodyException {
        if(theaterDto.getTheaterName()==null || theaterDto.getTheaterName().equals(""))
            throw new InvalidTheaterRequestBodyException("Theater name is empty or null");
        else if(theaterDto.getCapacity()<=0)
            throw new InvalidTheaterRequestBodyException("Theater capacity is invalid");
        else if(theaterDto.getCityId()<=0)
            throw new InvalidTheaterRequestBodyException("City ID is invalid");
        return true;
    }
}
