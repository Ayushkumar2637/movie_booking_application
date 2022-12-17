package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Exception.UserDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.Impl.BookingServicesImpl;
import com.ayushkumar.moviebooking.Services.Impl.LanguageServicesImpl;
import com.ayushkumar.moviebooking.Services.Impl.UserTypeServicesImpl;
import com.ayushkumar.moviebooking.Services.Impl.UsersServicesImpl;
import com.ayushkumar.moviebooking.Entity.Booking;
import com.ayushkumar.moviebooking.Entity.Language;
import com.ayushkumar.moviebooking.Entity.UserType;
import com.ayushkumar.moviebooking.Entity.Users;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceImplTest {

    @Autowired
    private UsersServicesImpl usersServicesImpl;
    @Autowired
    private UserTypeServicesImpl userTypeServicesImpl;
    @Autowired
    private BookingServicesImpl bookingServicesImpl;
    @Autowired
    private LanguageServicesImpl languageServicesImpl;

    private Users users;

    @Test
    @Order(1)
    public void testAcceptUserDetails(){
        users=new Users(0,"Ayush","Kumar","ayushkumar","password", LocalDateTime.of(2002,02,26,7,0));
        UserType userType=new UserType(0,"admin");
        UserType savedUserType=userTypeServicesImpl.acceptUserTypeDetails(userType);
        Booking booking=new Booking(0,LocalDateTime.now(),5);
        Booking savedBooking=bookingServicesImpl.acceptBookingDetails(booking);
        Language language=new Language(0,"hindi");
        Language savedLanguage=languageServicesImpl.acceptLanguageDetails(language);
        users.setUsertype(savedUserType);
        users.setBooking(new ArrayList<>(Arrays.asList(savedBooking)));
        users.setLanguage(savedLanguage);

        Users savedUser=usersServicesImpl.acceptUserDetails(users);

        Assertions.assertNotNull(savedUser);
        Assertions.assertEquals(4,savedUser.getUserId());
    }

    @Test
    @Order(2)
    public void testGetUserDetailsById() throws UserDetailsNotFoundException {
        Users fetchedUser=usersServicesImpl.getUserDetailsById(4);

        Assertions.assertNotNull(fetchedUser);
        Assertions.assertEquals(4,fetchedUser.getUserId());
    }

    @Test
    @Order(3)
    public void testGetUserDetailsByName() throws UserDetailsNotFoundException {
        Users fetchedUser=usersServicesImpl.getUserDetailsByName("AYUSH");

        Assertions.assertNotNull(fetchedUser);
        Assertions.assertEquals("Ayush",fetchedUser.getFirstName());
    }

    @Test
    @Order(4)
    public void testUpdateUserDetails() throws UserDetailsNotFoundException {
        Users forUpdate=new Users();
        forUpdate.setPassword("12345678");

        Users updatedUser=usersServicesImpl.updateUserDetails(4,forUpdate);

        Assertions.assertNotNull(updatedUser);
        Assertions.assertEquals("12345678",updatedUser.getPassword());
    }

    @Test
    @Order(6)
    public void testDeleteUser(){
        Assertions.assertTrue(usersServicesImpl.deleteUser(4));
    }

    @Test
    @Order(5)
    public void testGetAllUsersDetails(){
        List<Users> list=usersServicesImpl.getAllUsersDetails();

        Assertions.assertNotNull(list);
        Assertions.assertEquals(4,list.get(0).getUserId());
    }
}
