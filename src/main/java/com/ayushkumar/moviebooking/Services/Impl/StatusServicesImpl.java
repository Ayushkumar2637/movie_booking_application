package com.ayushkumar.moviebooking.Services.Impl;

import com.ayushkumar.moviebooking.Exception.StatusDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.StatusServices;
import com.ayushkumar.moviebooking.Daos.StatusDao;
import com.ayushkumar.moviebooking.Entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service is used to get bean than what about daos interface ?
@Service
public class StatusServicesImpl implements StatusServices {

    // Dependency Injection
    @Autowired
    private StatusDao statusDao;

    @Override
    public Status acceptStatusDetails(Status status) {
        return statusDao.save(status);
    }

    @Override
    public Status getStatusBasedOnId(int id) throws StatusDetailsNotFoundException{
        Status status=statusDao.findById(id).orElseThrow(()->
                new StatusDetailsNotFoundException("Status not found for the movie id : "+id));
         return status;
    }

    @Override
    public Status getStatusDetailsByStatusName(String name) throws StatusDetailsNotFoundException{
        Status status=statusDao.findByStatusNameIgnoreCase(name);
        if(status==null)
            throw new StatusDetailsNotFoundException("Status not found for the movie name : "+name);
        return status;
    }

    @Override
    public boolean deleteStatus(int id) {
        statusDao.deleteById(id);
        return true;
    }

    @Override
    public List<Status> getAllStatus() {
        return statusDao.findAll();
    }
}
