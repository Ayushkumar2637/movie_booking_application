package com.ayushkumar.moviebooking.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class MovieTheater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieTheaterId;

    @ManyToOne
    @JoinColumn(name="Movie_ID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="Theater_Id")
    private Theater theater;

//     Created by myself
    @OneToMany(mappedBy = "movieTheater")
    private List<Booking> booking;

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public MovieTheater(int movieTheaterId) {
        this.movieTheaterId = movieTheaterId;
    }

    public MovieTheater(){}

    public int getMovieTheaterId() {
        return movieTheaterId;
    }

    public void setMovieTheaterId(int movieTheaterId) {
        this.movieTheaterId = movieTheaterId;
    }

    @Override
    public String toString() {
        return "MovieTheater{" +
                "movieTheaterId=" + movieTheaterId +
                '}';
    }
}
