package com.ayushkumar.moviebooking.Services.Impl;

import com.ayushkumar.moviebooking.Exception.UserTypeDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.UserTypeServices;
import com.ayushkumar.moviebooking.Daos.UserTypeDao;
import com.ayushkumar.moviebooking.Entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServicesImpl implements UserTypeServices {

    @Autowired
    private UserTypeDao userTypeDao;

    @Override
    public UserType acceptUserTypeDetails(UserType userType) {
        return userTypeDao.save(userType);
    }

    @Override
    public UserType getUserTypeDetailsById(int id) throws UserTypeDetailsNotFoundException {
        UserType userType=userTypeDao.findById(id).orElseThrow(()->
                new UserTypeDetailsNotFoundException("UserType details not found for the userType id : "+id));
        return userType;
    }

    @Override
    public UserType updateUserType(int id, UserType userType) throws UserTypeDetailsNotFoundException {
        // fetch
        UserType fetcheduserType=userTypeDao.findById(id).orElseThrow(()->
                new UserTypeDetailsNotFoundException("UserType details not found for the userType id : "+id));
        // update
        if(userType.getUserTypeName()!=null)
            fetcheduserType.setUserTypeName(userType.getUserTypeName());
        // save
        return userTypeDao.save(fetcheduserType);
    }

    @Override
    public boolean deleteUserType(int id) {
        userTypeDao.deleteById(id);
        return true;
    }

    @Override
    public List<UserType> getAllUserTypeDetails() {
        return userTypeDao.findAll();
    }
}
