package com.ayushkumar.moviebooking.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusDto {

    @JsonProperty("status_id")
    private int statusId;
    @JsonProperty("status_name")
    private String statusName;

    public StatusDto() {
    }

    public StatusDto(int statusId,String statusName) {
        this.statusId = statusId;
        this.statusName=statusName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "StatusDto{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
