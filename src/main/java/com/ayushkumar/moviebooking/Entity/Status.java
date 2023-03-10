package com.ayushkumar.moviebooking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Status {
    @Id
    @GeneratedValue
    private int statusId;
    @Column(length = 20,nullable = false,unique = true)
    private String statusName;

    public Status(int statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }
    public Status(){}

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
        return "Status{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
