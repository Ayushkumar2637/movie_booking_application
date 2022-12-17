package com.ayushkumar.moviebooking.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class BookingDto {

    @JsonProperty("booking_id")
    private int bookingId;
    @JsonProperty("booking_date")
    private LocalDateTime bookingDate;
    @JsonProperty("no_of_seats")
    private int noOfSeats;

    @JsonProperty("movie_theater_id")
    private int movieTheaterId;
    @JsonProperty("users_id")
    private int usersId;

    public int getMovieTheaterId() {
        return movieTheaterId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setMovieTheaterId(int movieTheaterId) {
        this.movieTheaterId = movieTheaterId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public BookingDto(){}
    public BookingDto(int bookingId,LocalDateTime bookingDate,int noOfSeats) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.noOfSeats = noOfSeats;
    }

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
        return "BookingDto{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", noOfSeats=" + noOfSeats +
                ", movieTheaterId=" + movieTheaterId +
                ", usersId=" + usersId +
                '}';
    }
}
