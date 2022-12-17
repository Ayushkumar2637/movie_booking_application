package com.ayushkumar.moviebooking.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserTypeDto {

    @JsonProperty("user_type_id")
    private int userTypeId;
    @JsonProperty("user_type_name")
    private String userTypeName = "Customer";

    public UserTypeDto() {
    }

    public UserTypeDto(int userTypeId,String userTypeName) {
        this.userTypeId = userTypeId;
        this.userTypeName=userTypeName;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @Override
    public String toString() {
        return "UserTypeDto{" +
                "userTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
