package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Exception.UserDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.Impl.UsersServicesImpl;
import com.ayushkumar.moviebooking.Daos.UsersDao;
import com.ayushkumar.moviebooking.Entity.Booking;
import com.ayushkumar.moviebooking.Entity.Language;
import com.ayushkumar.moviebooking.Entity.UserType;
import com.ayushkumar.moviebooking.Entity.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServicesImplUnitTest {

    @Mock
    private UsersDao usersDao;
    @InjectMocks
    private UsersServicesImpl usersServicesImpl;

    private Users users;

    @BeforeEach
    public void beforeEach(){
        users=new Users(1,"Ayush","Kumar","ayushkumar","password", LocalDateTime.of(2002,02,26,7,0));
        UserType userType=new UserType(2,"admin");
        Booking booking=new Booking(3,LocalDateTime.now(),5);
        Language language=new Language(4,"hindi");
        users.setUsertype(userType);
        users.setLanguage(language);
        users.setBooking(new ArrayList<>(Arrays.asList(booking)));
    }

    @Test
    public void testAcceptUserDetails(){
        Mockito.when(usersDao.save(users)).thenReturn(users);

        Users savedUser=usersServicesImpl.acceptUserDetails(users);

        Assertions.assertEquals(1,savedUser.getUserId());
    }

    @Test
    public void testGetUserDetailsById() throws UserDetailsNotFoundException {
        Mockito.when(usersDao.findById(1)).thenReturn(java.util.Optional.ofNullable(users));

        Users fetchedUser=usersServicesImpl.getUserDetailsById(1);

        Assertions.assertEquals(1,fetchedUser.getUserId());
    }

    @Test
    public void testGetUserDetailsByName() throws UserDetailsNotFoundException {
        Mockito.when(usersDao.findUsersByFirstNameIgnoreCase("Ayush")).thenReturn(java.util.Optional.ofNullable(users));

        Users fetchedUser=usersServicesImpl.getUserDetailsByName("Ayush");

        Assertions.assertNotNull(fetchedUser);
        Assertions.assertEquals("Ayush",fetchedUser.getFirstName());
    }

    @Test
    public void testUpdateUserDetails() throws UserDetailsNotFoundException {
        Users forUpdate=new Users();
        forUpdate.setPassword("12345678");

        Mockito.when(usersDao.findById(1)).thenReturn(java.util.Optional.ofNullable(users));
        Mockito.when(usersDao.save(users)).thenReturn(users);

        Users updatedUser=usersServicesImpl.updateUserDetails(1,forUpdate);

        Assertions.assertEquals("12345678",updatedUser.getPassword());
    }

    @Test
    public void testDeleteUser(){
        Assertions.assertTrue(usersServicesImpl.deleteUser(1));
    }

    @Test
    public void testGetAllUsersDetails(){
        Mockito.when(usersDao.findAll()).thenReturn(new ArrayList<>(Arrays.asList(users)));

        List<Users> list=usersServicesImpl.getAllUsersDetails();

        Assertions.assertNotNull(list);
        Assertions.assertEquals(1,list.get(0).getUserId());
    }
}
