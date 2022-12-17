package com.ayushkumar.moviebooking.Daos;

import com.ayushkumar.moviebooking.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//No code written inside this interface also can give power to this interface for doing CURD operation

public interface MovieDao extends JpaRepository<Movie,Integer> {

    // For do some extra operations on database we need to define method signature with some naming conventions
    // convention : find<Entityname>By<Columnname>
    public Movie findMovieByMovieName(String moviename);

    // Search movie based on name and durtion
    public Movie findMovieByMovieNameAndDuration(String moviename,double duration);

    // Search based on condiction also possible

    public List<Movie> findByDurationGreaterThanEqual(double duration);
    public List<Movie> findByMovieNameContaining(String word);
    public List<Movie> findByMovieNameIgnoreCase(String moviename);
}
