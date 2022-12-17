package com.ayushkumar.moviebooking.Validators;

import com.ayushkumar.moviebooking.Dtos.StatusDto;
import com.ayushkumar.moviebooking.Exception.InvaidStatusRequestBodyException;

public class StatusDtoValidators {
    public static boolean isValid(StatusDto statusDto) throws InvaidStatusRequestBodyException {
        if(statusDto.getStatusName()==null || statusDto.getStatusName().equals(""))
            throw new InvaidStatusRequestBodyException("Status name is empty or null");
        return true;
    }
}
