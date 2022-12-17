package com.ayushkumar.moviebooking.Entity;

import javax.persistence.*;

@Entity
public class UserType {
    @Id
    @GeneratedValue
    private int userTypeId;
    @Column(length = 20,unique = true)
    private String userTypeName = "Customer";

    public UserType(int userTypeId,String userTypeName) {
        this.userTypeId = userTypeId;
        this.userTypeName=userTypeName;
    }
    public UserType(){}

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
        return "UserType{" +
                "userTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
