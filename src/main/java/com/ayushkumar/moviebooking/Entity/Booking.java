package com.ayushkumar.moviebooking.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private int bookingId;
    @Column(nullable = false)
    private LocalDateTime bookingDate;
    @Column(nullable = false)
    private int noOfSeats;

    @ManyToOne
    @JoinColumn(name="Movie_Theater_Id")
    private MovieTheater movieTheater;
    @ManyToOne
    //@JsonManagedReference
    @JoinColumn(name="Users_id")
    private Users users;

    public MovieTheater getMovieTheater() {
        return movieTheater;
    }

    public Users getUsers() {
        return users;
    }

    public void setMovieTheater(MovieTheater movieTheater) {
        this.movieTheater = movieTheater;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Booking(int bookingId, LocalDateTime bookingDate, int noOfSeats) {
        this.bookingId = bookingId;
        this.bookingDate=bookingDate;
        this.noOfSeats=noOfSeats;
    }
    public Booking(){}

    public int getBookingId() {
        return bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", noOfSeats=" + noOfSeats +
                '}';
    }
}
