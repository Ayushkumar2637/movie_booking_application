package com.ayushkumar.moviebooking.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CityDto {

    @JsonProperty("city_id")
    private int cityId;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("theaters_id")
    private List<Integer> theatersId;

    public List<Integer> getTheatersId() {
        return theatersId;
    }

    public void setTheatersId(List<Integer> theatersId) {
        this.theatersId = theatersId;
    }

    public CityDto() {}

    public CityDto(int cityId,String cityName) {
        this.cityId = cityId;
        this.cityName=cityName;
    }

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
        return "CityDto{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", theatersId=" + theatersId +
                '}';
    }
}
