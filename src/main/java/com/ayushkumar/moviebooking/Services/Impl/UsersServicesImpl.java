package com.ayushkumar.moviebooking.Services.Impl;

import com.ayushkumar.moviebooking.Exception.UserDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.UsersServices;
import com.ayushkumar.moviebooking.Daos.UsersDao;
import com.ayushkumar.moviebooking.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServicesImpl implements UsersServices {

    @Autowired
    private UsersDao usersDao;

    @Override
    public Users acceptUserDetails(Users users) {
        return usersDao.save(users);
    }

    @Override
    public Users getUserDetailsById(int id) throws UserDetailsNotFoundException {
        Users users=usersDao.findById(id).orElseThrow(()->
                new UserDetailsNotFoundException("User details not found for the user id : "+id));
        return users;
    }

    @Override
    public Users getUserDetailsByName(String name) throws UserDetailsNotFoundException {
        Users users=usersDao.findUsersByFirstNameIgnoreCase(name).orElseThrow(()->
                new UserDetailsNotFoundException("User details not found for the user name : "+name));
        return users;
    }

    @Override
    public Users updateUserDetails(int id, Users users) throws UserDetailsNotFoundException {
        // fetch user
        Users fetchedusers=usersDao.findById(id).orElseThrow(()->
                new UserDetailsNotFoundException("User details not found for the user id : "+id));
        // update details
        if(users.getFirstName()!=null)
            fetchedusers.setFirstName(users.getFirstName());
        if(users.getLastName()!=null)
            fetchedusers.setLastName(users.getLastName());
        if(users.getUsername()!=null)
            fetchedusers.setUsername(users.getUsername());
        if(users.getPassword()!=null)
            fetchedusers.setPassword(users.getPassword());
        if(users.getDateOfBirth()!=null)
            fetchedusers.setDateOfBirth(users.getDateOfBirth());
        if(users.getUsertype()!=null)
            fetchedusers.setUsertype(users.getUsertype());
        if(users.getBooking()!=null)
            fetchedusers.setBooking(users.getBooking());
        if(users.getLanguage()!=null)
            fetchedusers.setLanguage(users.getLanguage());
        // saved in DB
        return usersDao.save(fetchedusers);
    }

    @Override
    public boolean deleteUser(int id) {
        usersDao.deleteById(id);
        return true;
    }

    @Override
    public List<Users> getAllUsersDetails() {
        return usersDao.findAll();
    }
}
