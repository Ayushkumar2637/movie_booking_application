package com.ayushkumar.moviebooking.Controllers;

import com.ayushkumar.moviebooking.Dtos.UsersDto;
import com.ayushkumar.moviebooking.Entity.Booking;
import com.ayushkumar.moviebooking.Entity.Users;
import com.ayushkumar.moviebooking.Exception.*;
import com.ayushkumar.moviebooking.Services.BookingServices;
import com.ayushkumar.moviebooking.Services.LanguageServices;
import com.ayushkumar.moviebooking.Services.UserTypeServices;
import com.ayushkumar.moviebooking.Services.UsersServices;
import com.ayushkumar.moviebooking.Validators.UsersDtoValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersServices usersServices;
    @Autowired
    private UserTypeServices userTypeServices;
    @Autowired
    private BookingServices bookingServices;
    @Autowired
    private LanguageServices languageServices;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UsersDto usersDto) throws UserTypeDetailsNotFoundException, BookingDetailsNotFoundException, LanguageDetailsNotFoundException, InvalidUsersRequestBodyException {
        UsersDtoValidators.isValid(usersDto);
        Users users=convertToUsers(usersDto);
        Users savedUsers=usersServices.acceptUserDetails(users);
        UsersDto usersDto1=convertToUsersDto(savedUsers);
        return new ResponseEntity(usersDto1, HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity getUserById(@PathVariable("id") int id) throws UserDetailsNotFoundException {
        Users fetchedUser=usersServices.getUserDetailsById(id);
        UsersDto usersDto=convertToUsersDto(fetchedUser);
        return new ResponseEntity(usersDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        List<Users> users=usersServices.getAllUsersDetails();
        List<UsersDto> usersDtos=new ArrayList<>();
        for(Users users1 : users)
            usersDtos.add(convertToUsersDto(users1));
        return new ResponseEntity(usersDtos,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable("id") int id,@RequestBody UsersDto usersDto) throws UserTypeDetailsNotFoundException, BookingDetailsNotFoundException, LanguageDetailsNotFoundException, UserDetailsNotFoundException {
        Users users=convertToUsers(usersDto);
        Users updatedUser=usersServices.updateUserDetails(id,users);
        UsersDto usersDto1=convertToUsersDto(updatedUser);
        return new ResponseEntity(usersDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id){
        boolean res=usersServices.deleteUser(id);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    private UsersDto convertToUsersDto(Users savedUsers) {
        UsersDto usersDto=new UsersDto(savedUsers.getUserId(),savedUsers.getFirstName(),savedUsers.getLastName(),savedUsers.getUsername(),savedUsers.getPassword(),savedUsers.getDateOfBirth());
        if(savedUsers.getUsertype()!=null)
            usersDto.setUserTypeId(savedUsers.getUsertype().getUserTypeId());
        if(savedUsers.getBooking()!=null){
            List<Integer> bookingsId=new ArrayList<>();
            List<Booking> bookings=savedUsers.getBooking();
            for(int i=0;i<bookings.size();i++){
                bookingsId.add(bookings.get(i).getBookingId());
            }
            usersDto.setBookingsId(bookingsId);
        }
        if(savedUsers.getLanguage()!=null)
            usersDto.setLangId(savedUsers.getLanguage().getLanguageId());
        return usersDto;
    }

    private Users convertToUsers(UsersDto usersDto) throws UserTypeDetailsNotFoundException, BookingDetailsNotFoundException, LanguageDetailsNotFoundException {
        Users users=new Users(usersDto.getUserId(),usersDto.getFirstName(),usersDto.getLastName(),usersDto.getUsername(),usersDto.getPassword(),usersDto.getDateOfBirth());
        if(usersDto.getUserTypeId()!=0)
            users.setUsertype(userTypeServices.getUserTypeDetailsById(usersDto.getUserTypeId()));
        if(usersDto.getBookingsId()!=null){
            List<Integer> list=usersDto.getBookingsId();
            List<Booking> bookings=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                bookings.add(bookingServices.getBookingDetailsById(list.get(i)));
            }
            users.setBooking(bookings);
        }
        if(usersDto.getLangId()!=0)
            users.setLanguage(languageServices.getLanguageDetailsById(usersDto.getLangId()));
        return users;
    }

}
