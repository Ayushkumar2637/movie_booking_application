package com.ayushkumar.moviebooking.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue
    private int cityId;
    @Column(length=20,nullable = false,unique = true)
    private String cityName;

    /*
    If mappedBy is not used here then it create an extra table on database layer which are not useful because foren
    key is already present in theater table
     */
    @OneToMany(mappedBy = "city")
    private List<Theater> theaters; // There used set<Theater> (fetch = FetchType.EAGER constrain)

    public List<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
    }

    public City(int cityId, String cityName){
        this.cityId=cityId;
        this.cityName=cityName;
    }
    public City(){}

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
