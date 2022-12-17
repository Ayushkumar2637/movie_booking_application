package com.ayushkumar.moviebooking.Controllers;

import com.ayushkumar.moviebooking.Dtos.TheaterDto;
import com.ayushkumar.moviebooking.Exception.CityDetailsNotFoundException;
import com.ayushkumar.moviebooking.Exception.InvalidTheaterRequestBodyException;
import com.ayushkumar.moviebooking.Exception.TheaterDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.CityServices;
import com.ayushkumar.moviebooking.Services.TheaterServices;
import com.ayushkumar.moviebooking.Entity.City;
import com.ayushkumar.moviebooking.Entity.Theater;
import com.ayushkumar.moviebooking.Validators.TheaterDtoValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// able to open both find theater by name and price less than equal at same time but with slight change in uri
@RestController
@RequestMapping("/theaters")
public class TheaterController {

    @Autowired
    private TheaterServices theaterServices;
    @Autowired
    private CityServices cityServices;

    @PostMapping
    public ResponseEntity createTheater(@RequestBody TheaterDto theaterDto) throws CityDetailsNotFoundException, InvalidTheaterRequestBodyException {
        TheaterDtoValidators.isValid(theaterDto);
        Theater theater=convertToTheater(theaterDto);
        Theater savedTheater=theaterServices.acceptTheaterDetails(theater);
        TheaterDto theaterDto1=convertToTheaterDto(savedTheater);
        return new ResponseEntity(theaterDto1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{name}")
    public ResponseEntity getTheaterByName(@PathVariable("name") String name) throws TheaterDetailsNotFoundException {
        Theater fetchedTheater=theaterServices.getTheaterDetailsByName(name);
        TheaterDto theaterDto=convertToTheaterDto(fetchedTheater);
        return new ResponseEntity(theaterDto,HttpStatus.OK);
    }

    @GetMapping("/{price}/")
    public ResponseEntity getTheaterByPriceLessThanEqual(@PathVariable("price") float price){
        List<Theater> theaters=theaterServices.getTheaterDetailsPriceLessThanEqual(price);
        List<TheaterDto> theatersDtos=new ArrayList<>();
        for(int i=0;i<theaters.size();i++){
            theatersDtos.add(convertToTheaterDto(theaters.get(i)));
        }
        return new ResponseEntity(theatersDtos,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllTheater(){
        List<Theater> theaters=theaterServices.getAllTheaterDetails();
        List<TheaterDto> theatersDtos=new ArrayList<>();
        for(int i=0;i<theaters.size();i++){
            theatersDtos.add(convertToTheaterDto(theaters.get(i)));
        }
        return new ResponseEntity(theatersDtos,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTheater(@PathVariable("id") int id,@RequestBody TheaterDto theaterDto) throws CityDetailsNotFoundException, TheaterDetailsNotFoundException {
        Theater theater=convertToTheater(theaterDto);
        Theater updatedTheater=theaterServices.updateTheaterDetails(id,theater);
        TheaterDto theaterDto1=convertToTheaterDto(updatedTheater);
        return new ResponseEntity(theaterDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTheater(@PathVariable("id") int id){
        boolean res=theaterServices.deleteTheater(id);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    private TheaterDto convertToTheaterDto(Theater savedTheater) {
        TheaterDto theaterDto=new TheaterDto(savedTheater.getTheaterId(),savedTheater.getTheaterName(),savedTheater.getTicketPrice(),savedTheater.getCapacity());
        if(savedTheater.getCity()!=null){
            theaterDto.setCityId(savedTheater.getCity().getCityId());
        }
        return theaterDto;
    }

    private Theater convertToTheater(TheaterDto theaterDto) throws CityDetailsNotFoundException {
        Theater theater=new Theater(theaterDto.getTheaterId(),theaterDto.getTheaterName(),theaterDto.getTicketPrice(),theaterDto.getCapacity());
        if(theaterDto.getCityId()!=0){
            City fetchedCity=cityServices.getCityDetailsById(theaterDto.getCityId());
            theater.setCity(fetchedCity);
        }
        return theater;
    }

}
