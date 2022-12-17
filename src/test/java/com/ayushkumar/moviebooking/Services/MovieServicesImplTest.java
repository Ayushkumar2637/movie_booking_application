package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Exception.MovieDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.Impl.MovieServicesImpl;
import com.ayushkumar.moviebooking.Services.Impl.StatusServicesImpl;
import com.ayushkumar.moviebooking.Entity.Movie;
import com.ayushkumar.moviebooking.Entity.Status;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieServicesImplTest {
    // Used to test the MoviveServicesImpl class

    @Autowired
    private MovieServicesImpl movieServicesImpl;
    @Autowired
    private  StatusServicesImpl statusServicesImpl;

    private  Movie movie;

//    @BeforeAll
//    public static void beforeEach(){
//        Status status=new Status(0,"Relesed");
//        Status savedStatus=statusServicesImpl.acceptStatusDetails(status);
//        movie=new Movie(0,"kgf","good movie", LocalDateTime.now(),120,"www.corevkgf.com","trailerKgf");
//        movie.setStatus(savedStatus);
//    }

    // This method is used to test acceptMovieDetails method
    @Test
    @Order(1)
    public void testAcceptMovieDetails(){
        // Assign data
        Status status=new Status(0,"Relesed");
        Status savedStatus=statusServicesImpl.acceptStatusDetails(status);
        movie=new Movie(0,"kgf","good movie", LocalDateTime.now(),120,"www.corevkgf.com","trailerKgf");
        movie.setStatus(savedStatus);
        // method call
        Movie savedMovie=movieServicesImpl.acceptMovieDetails(movie);
        // Cheak that actual value is matched with expected or not
        Assertions.assertNotNull(savedMovie);
        Assertions.assertEquals(2,savedMovie.getMovieId());
    }

    // This method is used to test getMovieBasedOnId method
    @Test
    @Order(2)
    public void testGetMovieBasedOnId() throws MovieDetailsNotFoundException {
        // Assign data
        // method call
        Movie fetchedMovie=movieServicesImpl.getMovieBasedOnId(2);
        // cheak
        Assertions.assertNotNull(fetchedMovie);
        Assertions.assertEquals(2,fetchedMovie.getMovieId());
    }

    // This method is used to test getMovieBasedOnName method
    @Test
    @Order(3)
    public void testGetMovieBasedOnName() throws MovieDetailsNotFoundException {
        // Assign data in DB is done
        // method call
        List<Movie> fetchedMovie=movieServicesImpl.getMovieBasedOnName("kgf");
        // cheak
        Assertions.assertNotNull(fetchedMovie);
        Assertions.assertEquals("kgf",fetchedMovie.get(0).getMovieName());
    }

    // This method is used to test updateMovieDetails method
    @Test
    @Order(4)
    public void testUpdateMovieDetails() throws MovieDetailsNotFoundException {
        // creating a new movie object for update duration
        Movie forUpdate=new Movie();
        forUpdate.setDuration(150);
        // method call
        Movie updatedMovie=movieServicesImpl.updateMovieDetails(2,forUpdate);
        // cheak
        Assertions.assertNotNull(updatedMovie);
        Assertions.assertEquals(150,updatedMovie.getDuration());
    }

    // This method is used to test deleteMovie method
    @Test
    @Order(6)
    public void testDeleteMovie() throws MovieDetailsNotFoundException {
        // Assign data in DB is done
        // method call
        boolean value=movieServicesImpl.deleteMovie(2);
        // cheak
        Assertions.assertTrue(value);
    }

    // This method is used to test getAllMovieDetails method
    @Test
    @Order(5)
    public void testGetAllMovieDetails(){
        // assign data in DB is done
        // method call
        List<Movie> list=movieServicesImpl.getAllMovieDetails();
        // cheak
        Assertions.assertNotNull(list);
        Assertions.assertEquals(2,list.get(0).getMovieId());
    }
}
