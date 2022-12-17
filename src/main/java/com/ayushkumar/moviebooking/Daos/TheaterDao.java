package com.ayushkumar.moviebooking.Daos;

import com.ayushkumar.moviebooking.Entity.City;
import com.ayushkumar.moviebooking.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TheaterDao extends JpaRepository<Theater,Integer> {
    public Optional<Theater> findTheaterByTheaterNameIgnoreCase(String theaterName);
    public List<Theater> findByTicketPriceLessThanEqual(float ticketPrice);
}
