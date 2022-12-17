package com.ayushkumar.moviebooking.Controllers;

import com.ayushkumar.moviebooking.Dtos.UserTypeDto;
import com.ayushkumar.moviebooking.Entity.UserType;
import com.ayushkumar.moviebooking.Exception.UserTypeDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.UserTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usertypes")
public class UserTypeController {

    @Autowired
    private UserTypeServices userTypeServices;

    @PostMapping
    public ResponseEntity createUserType(@RequestBody UserTypeDto userTypeDto){
        UserType userType=convertToUserType(userTypeDto);
        UserType savedUserType=userTypeServices.acceptUserTypeDetails(userType);
        UserTypeDto userTypeDto1=convertToUserTypeDto(savedUserType);
        return new ResponseEntity(userTypeDto1, HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity getUserTypeById(@PathVariable("id") int id) throws UserTypeDetailsNotFoundException {
        UserType fetchedUserType=userTypeServices.getUserTypeDetailsById(id);
        UserTypeDto userTypeDto=convertToUserTypeDto(fetchedUserType);
        return new ResponseEntity(userTypeDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUserType(){
        List<UserType> userTypes=userTypeServices.getAllUserTypeDetails();
        List<UserTypeDto> userTypeDtos=new ArrayList<>();
        for(UserType userType : userTypes)
            userTypeDtos.add(convertToUserTypeDto(userType));
        return new ResponseEntity(userTypeDtos,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUserType(@PathVariable("id") int id,@RequestBody UserTypeDto userTypeDto) throws UserTypeDetailsNotFoundException {
        UserType userType=convertToUserType(userTypeDto);
        UserType updatedUserType=userTypeServices.updateUserType(id,userType);
        UserTypeDto userTypeDto1=convertToUserTypeDto(updatedUserType);
        return new ResponseEntity(userTypeDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserType(@PathVariable("id") int id){
        return new ResponseEntity(userTypeServices.deleteUserType(id),HttpStatus.OK);
    }

    private UserTypeDto convertToUserTypeDto(UserType savedUserType) {
        UserTypeDto userTypeDto=new UserTypeDto(savedUserType.getUserTypeId(),savedUserType.getUserTypeName());
        return userTypeDto;
    }

    private UserType convertToUserType(UserTypeDto userTypeDto) {
        UserType userType=new UserType(userTypeDto.getUserTypeId(),userTypeDto.getUserTypeName());
        return userType;
    }


}
