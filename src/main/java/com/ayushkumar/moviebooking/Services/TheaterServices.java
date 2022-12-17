package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Entity.City;
import com.ayushkumar.moviebooking.Exception.TheaterDetailsNotFoundException;
import com.ayushkumar.moviebooking.Entity.Theater;

import java.util.List;

public interface TheaterServices {
    public Theater acceptTheaterDetails(Theater theater);
    public Theater getTheaterDetailsById(int id) throws TheaterDetailsNotFoundException;
    public Theater getTheaterDetailsByName(String name) throws TheaterDetailsNotFoundException;
    public List<Theater> getTheaterDetailsPriceLessThanEqual(float price);
    public Theater updateTheaterDetails(int id,Theater theater) throws TheaterDetailsNotFoundException;
    public boolean deleteTheater(int id);
    public List<Theater> getAllTheaterDetails();
}
