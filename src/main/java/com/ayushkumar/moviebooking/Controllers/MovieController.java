package com.ayushkumar.moviebooking.Controllers;

import com.ayushkumar.moviebooking.Dtos.MovieDto;
import com.ayushkumar.moviebooking.Exception.InvalidMovieRequestBodyException;
import com.ayushkumar.moviebooking.Exception.MovieDetailsNotFoundException;
import com.ayushkumar.moviebooking.Exception.StatusDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.MovieServices;
import com.ayushkumar.moviebooking.Services.StatusServices;
import com.ayushkumar.moviebooking.Entity.Movie;
import com.ayushkumar.moviebooking.Entity.Status;
import com.ayushkumar.moviebooking.Validators.MovieDtoValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// able to find movie by id or name but with having little change in uri
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieServices movieServices;
    @Autowired
    private StatusServices statusServices;

    @PostMapping
    public ResponseEntity createMovie(@RequestBody MovieDto movieDto) throws StatusDetailsNotFoundException, InvalidMovieRequestBodyException {
        MovieDtoValidators.isValid(movieDto);
        Movie convertToMovie=convertToMovie(movieDto);
        Movie savedMovie= movieServices.acceptMovieDetails(convertToMovie);
        MovieDto convertToMovieDto=convertToMovieDto(savedMovie);
        return new ResponseEntity(convertToMovieDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/")
    public ResponseEntity getMovieById(@PathVariable("id") int id) throws MovieDetailsNotFoundException {
        Movie fetchedMovie=movieServices.getMovieBasedOnId(id);
        MovieDto fetchedMovieDto=convertToMovieDto(fetchedMovie);
        return new ResponseEntity(fetchedMovieDto,HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name) throws MovieDetailsNotFoundException {
        List<Movie> fetchedMovie = movieServices.getMovieBasedOnName(name);
        List<MovieDto> movieDtos = new ArrayList<>();
        for (int i = 0; i < fetchedMovie.size(); i++) {
            movieDtos.add(convertToMovieDto(fetchedMovie.get(i)));
        }
        return new ResponseEntity(movieDtos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllMovie(){
        List<Movie> movies= movieServices.getAllMovieDetails();
        List<MovieDto> movieDtos=new ArrayList<>();
        for(int i=0;i<movies.size();i++){
            movieDtos.add(convertToMovieDto(movies.get(i)));
        }
        return new ResponseEntity(movieDtos,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMovie(@PathVariable("id") int id,@RequestBody MovieDto movieDto) throws StatusDetailsNotFoundException, MovieDetailsNotFoundException {
        Movie movie=convertToMovie(movieDto);
        Movie updatedMovie= movieServices.updateMovieDetails(id,movie);
        MovieDto movieDto1=convertToMovieDto(updatedMovie);
        return new ResponseEntity(movieDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") int id){
        boolean res= movieServices.deleteMovie(id);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    private MovieDto convertToMovieDto(Movie savedMovie) {
        MovieDto movieDto=new MovieDto(savedMovie.getMovieId(),savedMovie.getMovieName(),savedMovie.getMovieDescription()
        ,savedMovie.getReleaseDate(),savedMovie.getDuration(),savedMovie.getCoverPhotoUrl(),savedMovie.getTrailerUrl());

        // To support movie without status this if is been design
        if(savedMovie.getStatus()!=null)
            movieDto.setStatusId(savedMovie.getStatus().getStatusId());
        return movieDto;
    }

    private Movie convertToMovie(MovieDto movieDto) throws StatusDetailsNotFoundException {
        Movie movie=new Movie(movieDto.getMovieId(),movieDto.getMovieName(),movieDto.getMovieDescription(),movieDto.getReleaseDate(),
                                movieDto.getDuration(),movieDto.getCoverPhotoUrl(),movieDto.getTrailerUrl());

        // Due to this we insert a movie and before insert any status otherwise 1 st we have to create status 1st
        if(movieDto.getStatusId()!=0) {
            Status fetchedStatus = statusServices.getStatusBasedOnId(movieDto.getStatusId());
            movie.setStatus(fetchedStatus);
        }
        return movie;
    }

}
