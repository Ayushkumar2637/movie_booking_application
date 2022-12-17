package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Exception.StatusDetailsNotFoundException;
import com.ayushkumar.moviebooking.Entity.Status;

import java.util.List;

public interface StatusServices {
    // CRUD operations

    // Help to assign a status in DB
    public Status acceptStatusDetails(Status status);

    // Help to fetch the status
    public Status getStatusBasedOnId(int id) throws StatusDetailsNotFoundException;
    public Status getStatusDetailsByStatusName(String name) throws StatusDetailsNotFoundException;

    // Help to delete a status
    public boolean deleteStatus(int id);

    // Help to get all the details
    public List<Status> getAllStatus();

}
