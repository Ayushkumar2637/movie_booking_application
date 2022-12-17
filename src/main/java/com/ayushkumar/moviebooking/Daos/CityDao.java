package com.ayushkumar.moviebooking.Daos;

import com.ayushkumar.moviebooking.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
    public City findCityByCityNameIgnoreCase(String cityName);
}
