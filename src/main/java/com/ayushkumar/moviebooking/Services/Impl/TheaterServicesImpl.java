package com.ayushkumar.moviebooking.Services.Impl;

import com.ayushkumar.moviebooking.Entity.City;
import com.ayushkumar.moviebooking.Exception.TheaterDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.TheaterServices;
import com.ayushkumar.moviebooking.Daos.TheaterDao;
import com.ayushkumar.moviebooking.Entity.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServicesImpl implements TheaterServices {

    @Autowired
    private TheaterDao theaterDao;

    @Override
    public Theater acceptTheaterDetails(Theater theater) {
        return theaterDao.save(theater);
    }

    @Override
    public Theater getTheaterDetailsById(int id) throws TheaterDetailsNotFoundException {
        Theater fetchedTheater=theaterDao.findById(id).orElseThrow(()->
                new TheaterDetailsNotFoundException("Theater details not found for the theater id : "+id));
        return fetchedTheater;
    }

    @Override
    public Theater getTheaterDetailsByName(String name) throws TheaterDetailsNotFoundException {
        Theater theater=theaterDao.findTheaterByTheaterNameIgnoreCase(name).orElseThrow(()->
                new TheaterDetailsNotFoundException("Theater details not found for the theater name : "+name));
        return theater;
    }

    @Override
    public List<Theater> getTheaterDetailsPriceLessThanEqual(float price) {
        List<Theater> theaters=theaterDao.findByTicketPriceLessThanEqual(price);
        return theaters;
    }

    @Override
    public Theater updateTheaterDetails(int id, Theater theater) throws TheaterDetailsNotFoundException {
        // Fetch theater details
        Theater fetchtheater=theaterDao.findById(id).orElseThrow(()->
                new TheaterDetailsNotFoundException("Theater details not found for the theater id : "+id));
        // Update theater details
        if(theater.getTheaterName()!=null)
            fetchtheater.setTheaterName(theater.getTheaterName());
        if(theater.getTicketPrice()>0)
            fetchtheater.setTicketPrice(theater.getTicketPrice());
        if(theater.getCapacity()>0)
            fetchtheater.setCapacity(theater.getCapacity());
        if(theater.getCity()!=null)
            fetchtheater.setCity(theater.getCity());
        // Saved Update in DB
        return theaterDao.save(fetchtheater);
    }

    @Override
    public boolean deleteTheater(int id) {
        theaterDao.deleteById(id);
        return true;
    }

    @Override
    public List<Theater> getAllTheaterDetails() {
        return theaterDao.findAll();
    }
}
