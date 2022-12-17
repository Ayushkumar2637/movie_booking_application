package com.ayushkumar.moviebooking.Controllers;

import com.ayushkumar.moviebooking.Dtos.CityDto;
import com.ayushkumar.moviebooking.Exception.CityDetailsNotFoundException;
import com.ayushkumar.moviebooking.Exception.InvalidCityRequestBodyException;
import com.ayushkumar.moviebooking.Exception.TheaterDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.CityServices;
import com.ayushkumar.moviebooking.Services.TheaterServices;
import com.ayushkumar.moviebooking.Entity.City;
import com.ayushkumar.moviebooking.Entity.Theater;
import com.ayushkumar.moviebooking.Validators.CityDtoValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Able to get list of theaters only have to update city object in theater table
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityServices cityServices;
    @Autowired
    private TheaterServices theaterServices;

    @PostMapping
    public ResponseEntity createCity(@RequestBody CityDto cityDto) throws TheaterDetailsNotFoundException, InvalidCityRequestBodyException {
        CityDtoValidators.isValid(cityDto);
        City city=convertToCity(cityDto);
        City savedCity= cityServices.acceptCityDetails(city);
        CityDto cityDto1=convertToCityDto(savedCity);
        return new ResponseEntity(cityDto1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String name) throws CityDetailsNotFoundException {
        City fetchedCity= cityServices.getCityDetailsByName(name);
        CityDto cityDto=convertToCityDto(fetchedCity);
        return new ResponseEntity(cityDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCity(){
        List<City> cities= cityServices.getAllCityDetails();
        List<CityDto> citiesDto=new ArrayList<>();
        for(int i=0;i<cities.size();i++){
            citiesDto.add(convertToCityDto(cities.get(i)));
        }
        return new ResponseEntity(citiesDto,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCity(@PathVariable("id") int id,@RequestBody CityDto cityDto) throws TheaterDetailsNotFoundException, CityDetailsNotFoundException {
        City city=convertToCity(cityDto);
        City updatedCity= cityServices.updateCityDetails(id,city);
        CityDto cityDto1=convertToCityDto(updatedCity);
        return new ResponseEntity(cityDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int id){
        boolean res= cityServices.deleteCity(id);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    private CityDto convertToCityDto(City savedCity) {
        CityDto cityDto=new CityDto(savedCity.getCityId(),savedCity.getCityName());
        if(savedCity.getTheaters()!=null) {
            List<Integer> theatersId = new ArrayList<>();
            List<Theater> theaters=savedCity.getTheaters();
            for(int i=0;i<theaters.size();i++){
                theatersId.add(theaters.get(i).getTheaterId());
            }
            cityDto.setTheatersId(theatersId);
        }
        return cityDto;
    }

    private City convertToCity(CityDto cityDto) throws TheaterDetailsNotFoundException {
        City city=new City(cityDto.getCityId(),cityDto.getCityName());
        if(cityDto.getTheatersId()!=null) {
            List<Theater> theater=new ArrayList<>();
            List<Integer> theaters=cityDto.getTheatersId();
            for(int i=0;i<theaters.size();i++){
                Theater fetchedTheater= theaterServices.getTheaterDetailsById(theaters.get(i));
                theater.add(fetchedTheater);
            }
            city.setTheaters(theater);
        }
        return city;
    }
}
