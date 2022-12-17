package com.ayushkumar.moviebooking.Dtos;

import com.ayushkumar.moviebooking.Entity.Booking;
import com.ayushkumar.moviebooking.Entity.Movie;
import com.ayushkumar.moviebooking.Entity.Theater;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieTheaterDto {

    @JsonProperty("movie_theater_id")
    private int movieTheaterId;

    @JsonProperty("movie_id")
    private int movieId;
    @JsonProperty("theater_id")
    private int theaterId;
    @JsonProperty("bookings_id")
    private List<Integer> bookingsId;

    public MovieTheaterDto() {
    }

    public MovieTheaterDto(int movieTheaterId) {
        this.movieTheaterId = movieTheaterId;
    }

    public int getMovieTheaterId() {
        return movieTheaterId;
    }

    public void setMovieTheaterId(int movieTheaterId) {
        this.movieTheaterId = movieTheaterId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public List<Integer> getBookingsId() {
        return bookingsId;
    }

    public void setBookingsId(List<Integer> bookingsId) {
        this.bookingsId = bookingsId;
    }

    @Override
    public String toString() {
        return "MovieTheaterDto{" +
                "movieTheaterId=" + movieTheaterId +
                ", movieId=" + movieId +
                ", theaterId=" + theaterId +
                ", bookingsId=" + bookingsId +
                '}';
    }
}
