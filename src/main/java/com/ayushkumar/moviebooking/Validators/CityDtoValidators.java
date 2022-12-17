package com.ayushkumar.moviebooking.Validators;

import com.ayushkumar.moviebooking.Dtos.CityDto;
import com.ayushkumar.moviebooking.Exception.InvalidCityRequestBodyException;

public class CityDtoValidators {
    public static boolean isValid(CityDto cityDto) throws InvalidCityRequestBodyException {
        if(cityDto.getCityName()==null || cityDto.getCityName().equals(""))
            throw new InvalidCityRequestBodyException("City name is empty or null");
        return true;
    }
}
