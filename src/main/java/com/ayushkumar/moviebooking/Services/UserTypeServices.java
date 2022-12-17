package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Exception.UserTypeDetailsNotFoundException;
import com.ayushkumar.moviebooking.Entity.UserType;

import java.util.List;

public interface UserTypeServices {
    public UserType acceptUserTypeDetails(UserType userType);
    public UserType getUserTypeDetailsById(int id) throws UserTypeDetailsNotFoundException;
    public UserType updateUserType(int id,UserType userType) throws UserTypeDetailsNotFoundException;
    public boolean deleteUserType(int id);
    public List<UserType> getAllUserTypeDetails();
}
