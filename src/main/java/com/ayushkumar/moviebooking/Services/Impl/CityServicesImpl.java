package com.ayushkumar.moviebooking.Services.Impl;

import com.ayushkumar.moviebooking.Exception.CityDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.CityServices;
import com.ayushkumar.moviebooking.Daos.CityDao;
import com.ayushkumar.moviebooking.Entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServicesImpl implements CityServices {

    @Autowired
    private CityDao cityDao;

    @Override
    public City acceptCityDetails(City city) {
        return cityDao.save(city);
    }

    @Override
    public City getCityDetailsById(int id) throws CityDetailsNotFoundException {
        City city=cityDao.findById(id).orElseThrow(()->
                new CityDetailsNotFoundException("City details not found for the city id : "+id));
        return city;
    }

    @Override
    public City getCityDetailsByName(String name) throws CityDetailsNotFoundException {
        City city=cityDao.findCityByCityNameIgnoreCase(name);
        if(city==null)
            throw new CityDetailsNotFoundException("City details not found for the city name : "+name);
        return city;
    }

    @Override
    public City updateCityDetails(int id, City city) throws CityDetailsNotFoundException {
        // Fetch city details
        City fetchedcity=cityDao.findById(id).orElseThrow(()->
                new CityDetailsNotFoundException("City details not found for the city id : "+id));
        // Update city details
        if(city.getCityName()!=null)
            fetchedcity.setCityName(city.getCityName());
        if(city.getTheaters()!=null)
            fetchedcity.setTheaters(city.getTheaters());
        // Save in DB
        City updatedCity=cityDao.save(fetchedcity);
        return updatedCity;
    }

    @Override
    public boolean deleteCity(int id) {
        cityDao.deleteById(id);
        return true;
    }

    @Override
    public List<City> getAllCityDetails() {
        return cityDao.findAll();
    }
}
