package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Exception.MovieDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.Impl.MovieServicesImpl;
import com.ayushkumar.moviebooking.Daos.MovieDao;
import com.ayushkumar.moviebooking.Entity.Movie;
import com.ayushkumar.moviebooking.Entity.Status;
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
public class MovieServicesImplUnitTest {

    // This will return a mocked obj always
    @Mock
    private MovieDao movieDao;

    // This will create obj of MovieServicesImpl and taking mocked obj
    @InjectMocks
    private MovieServicesImpl movieServicesImpl;

    private Movie movie;

    @BeforeEach
    public void beforeEach(){
        Status status=new Status(0,"Relesed");
        movie=new Movie(1,"kgf","good",LocalDateTime.now(),120,"cover","trailer");
        movie.setStatus(status);
    }

    @Test
    public void testAcceptMovieDetails(){
        // Assign data (Create movie obj with before each)
        // Declare mockito
        Mockito.when(movieDao.save(movie)).thenReturn(movie);
        // method call
        Movie savedMovie=movieServicesImpl.acceptMovieDetails(movie);
        // Check that actual value is matched with expected or not
        Assertions.assertNotNull(savedMovie);
        Assertions.assertEquals(1,savedMovie.getMovieId());
    }

    @Test
    public void testGetMovieBasedOnId() throws MovieDetailsNotFoundException {
        // Assign data (Create movie obj with before each)
        // declare mockito
        Mockito.when(movieDao.findById(1)).thenReturn(java.util.Optional.ofNullable(movie));
        // method call
        Movie savedMovie=movieServicesImpl.getMovieBasedOnId(1);
        // check
        Assertions.assertNotNull(savedMovie);
        Assertions.assertEquals(1,savedMovie.getMovieId());
    }

    @Test
    public void testGetMovieBasedOnName() throws MovieDetailsNotFoundException {
        // Assign data (Create movie obj with before each)
        // declare mockito
        Mockito.when(movieDao.findByMovieNameIgnoreCase("kgf")).thenReturn(new ArrayList<>(Arrays.asList(movie)));
        // method call
        List<Movie> list=movieServicesImpl.getMovieBasedOnName("kgf");
        // check
        Assertions.assertNotNull(list);
        Assertions.assertEquals("kgf",list.get(0).getMovieName());
    }

    @Test
    public void testUpdateMovieDetails() throws MovieDetailsNotFoundException {
        Movie forUpdate=new Movie();
        forUpdate.setDuration(150);
        Movie updated=new Movie(1,"kgf","good",LocalDateTime.now(),150,"cover","trailer");
        // declare mockito
        Mockito.when(movieDao.findById(1)).thenReturn(java.util.Optional.ofNullable(movie));
        Mockito.when(movieDao.save(movie)).thenReturn(updated);
        // method call
        Movie updatedMovie=movieServicesImpl.updateMovieDetails(1,forUpdate);
        // cheak
        System.out.println(movie.getReleaseDate());
        System.out.println(updatedMovie.getReleaseDate());
        Assertions.assertEquals(150,updatedMovie.getDuration());
    }

    @Test
    public void testDeleteMovie(){
        // method call
        boolean val=movieServicesImpl.deleteMovie(1);
        // check
        Assertions.assertTrue(val);
    }

    @Test
    public void testGetAllMovieDetails(){
        // declare mockito
        Mockito.when(movieDao.findAll()).thenReturn(new ArrayList<>(Arrays.asList(movie)));
        // method call
        List<Movie> list=movieServicesImpl.getAllMovieDetails();
        // check
        Assertions.assertNotNull(list);
        Assertions.assertEquals(1,list.get(0).getMovieId());
    }
}
