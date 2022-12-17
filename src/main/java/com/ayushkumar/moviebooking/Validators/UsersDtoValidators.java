package com.ayushkumar.moviebooking.Validators;

import com.ayushkumar.moviebooking.Dtos.UsersDto;
import com.ayushkumar.moviebooking.Exception.InvalidUsersRequestBodyException;

public class UsersDtoValidators {
    public static boolean isValid(UsersDto usersDto) throws InvalidUsersRequestBodyException {
        if(usersDto.getFirstName()==null || usersDto.getFirstName().equals(""))
            throw new InvalidUsersRequestBodyException("User first name is empty or null");
        else if(usersDto.getUsername()==null || usersDto.getUsername().equals(""))
            throw new InvalidUsersRequestBodyException("User username is empty or null");
        else if(usersDto.getPassword()==null || usersDto.getPassword().equals(""))
            throw new InvalidUsersRequestBodyException("User password is empty or null");
        else if(usersDto.getDateOfBirth()==null)
            throw new InvalidUsersRequestBodyException("User date of birth is null");
        else if(usersDto.getUserTypeId()<=0)
            throw new InvalidUsersRequestBodyException("User userType ID is Invalid");
        else if(usersDto.getLangId()<=0)
            throw new InvalidUsersRequestBodyException("User Language ID is Invalid");
        return true;
    }
}
