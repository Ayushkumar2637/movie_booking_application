package com.ayushkumar.moviebooking.Daos;

import com.ayushkumar.moviebooking.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking,Integer> {
}
