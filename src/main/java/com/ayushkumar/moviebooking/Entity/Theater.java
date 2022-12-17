package com.ayushkumar.moviebooking.Entity;

import javax.persistence.*;


@Entity
public class Theater {
    @Id
    @GeneratedValue
    private int theaterId;
    @Column(length = 20,nullable = false,unique = true)
    private String theaterName;
    @Column(nullable = false)
    private float ticketPrice = 150.00f;
    @Column(nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name="city_Id")
    //@JsonManagedReference
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Theater(int theaterId, String theaterName, float ticketPrice, int capacity) {
        this.theaterId = theaterId;
        this.theaterName=theaterName;
        this.ticketPrice=ticketPrice;
        this.capacity=capacity;
    }
    public Theater(){}

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
        return "Theater{" +
                "theaterId=" + theaterId +
                ", theaterName='" + theaterName + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
