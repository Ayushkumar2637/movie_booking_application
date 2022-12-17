package com.ayushkumar.moviebooking.Daos;

import com.ayushkumar.moviebooking.Entity.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheaterDao extends JpaRepository<MovieTheater,Integer> {
}
