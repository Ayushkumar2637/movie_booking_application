package com.ayushkumar.moviebooking.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TheaterDto {

    @JsonProperty("theater_id")
    private int theaterId;
    @JsonProperty("theater_name")
    private String theaterName;
    @JsonProperty("ticket_price")
    private float ticketPrice = 150.00f;
    @JsonProperty("capacity")   // To be cheak if didn't use annotation then it work? Yes works
    private int capacity;

    @JsonProperty("city_id")
    private int cityId;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public TheaterDto() {
    }
    public TheaterDto(int theaterId, String theaterName, float ticketPrice, int capacity) {
        this.theaterId = theaterId;
        this.theaterName=theaterName;
        this.ticketPrice=ticketPrice;
        this.capacity=capacity;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "TheaterDto{" +
                "theaterId=" + theaterId +
                ", theaterName='" + theaterName + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", capacity=" + capacity +
                ", cityId=" + cityId +
                '}';
    }
}
