package com.ayushkumar.moviebooking.Controllers;

import com.ayushkumar.moviebooking.Dtos.DemoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  // this is used to create bean of the class , indicate that it is controller class
                 // , any req came then first bring the req here
@RequestMapping("/moviebooking/v1/demos")    // routing -> tell the path of this class
public class DemoController {

    // This invoke when uri is Post 127.0.0.1:7777/moviebooking/v1/demos , with a req body , used for create a demo

    @PostMapping
    public ResponseEntity createDemo(@RequestBody DemoDto demoDto){
        System.out.println(demoDto);
        return new ResponseEntity("Demo is created : "+demoDto,HttpStatus.ACCEPTED);
    }

    // This invoke when uri is Get 127.0.0.1:7777/moviebooking/v1/demos

    @GetMapping
    public ResponseEntity getDemoResponses(){
        return new ResponseEntity("This msg is from get demo", HttpStatus.OK);
    }

    // This invoke when uri is Get 127.0.0.1:7777/moviebooking/v1/demos/{id} , things inside {} is variable

    @GetMapping("/{id}")
    public ResponseEntity getDemoResponseBasedOnId(@PathVariable("id") int id){
        return new ResponseEntity("This msg is from get demo : "+id, HttpStatus.OK);
    }

    // This invoke when uri is Put 127.0.0.1:7777/moviebooking/v1/demos  , with a req body

    @PutMapping
    public ResponseEntity updateDemo(@RequestBody DemoDto demoDto){
        System.out.println(demoDto);
        return new ResponseEntity(demoDto,HttpStatus.ACCEPTED);
    }

    // This invoke when uri is Delete 127.0.0.1:7777/moviebooking/v1/demos/{id} , things inside {} is variable

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDemo(@PathVariable("id") int id){
        return new ResponseEntity("This msg is from delete demo : "+id, HttpStatus.OK);
    }

}
