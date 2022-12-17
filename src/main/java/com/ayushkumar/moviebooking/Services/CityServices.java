package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Exception.CityDetailsNotFoundException;
import com.ayushkumar.moviebooking.Entity.City;

import java.util.List;

public interface CityServices {
    public City acceptCityDetails(City city);
    public City getCityDetailsById(int id) throws CityDetailsNotFoundException;
    public City getCityDetailsByName(String name) throws CityDetailsNotFoundException;
    public City updateCityDetails(int id,City city) throws CityDetailsNotFoundException;
    public boolean deleteCity(int id);
    public List<City> getAllCityDetails();
}
