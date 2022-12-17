package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Exception.UserDetailsNotFoundException;
import com.ayushkumar.moviebooking.Entity.Users;

import java.util.List;

public interface UsersServices {
    public Users acceptUserDetails(Users users);
    public Users getUserDetailsById(int id) throws UserDetailsNotFoundException;
    public Users getUserDetailsByName(String name) throws UserDetailsNotFoundException;
    public Users updateUserDetails(int id,Users users) throws UserDetailsNotFoundException;
    public boolean deleteUser(int id);
    public List<Users> getAllUsersDetails();
}
