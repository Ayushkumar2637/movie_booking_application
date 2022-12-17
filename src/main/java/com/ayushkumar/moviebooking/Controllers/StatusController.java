package com.ayushkumar.moviebooking.Controllers;

import com.ayushkumar.moviebooking.Dtos.StatusDto;
import com.ayushkumar.moviebooking.Exception.InvaidStatusRequestBodyException;
import com.ayushkumar.moviebooking.Exception.StatusDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.StatusServices;
import com.ayushkumar.moviebooking.Entity.Status;
import com.ayushkumar.moviebooking.Validators.StatusDtoValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private StatusServices statusServices;

    @PostMapping
    public ResponseEntity createStatus(@RequestBody StatusDto statusDto) throws InvaidStatusRequestBodyException {
        StatusDtoValidators.isValid(statusDto);
        Status status=convertToStatus(statusDto);
        Status savedStatus= statusServices.acceptStatusDetails(status);
        StatusDto statusDto1=conertToStatusDto(savedStatus);
        return new ResponseEntity(statusDto1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{name}")
    public ResponseEntity getStatusByName(@PathVariable("name") String name) throws StatusDetailsNotFoundException {
        Status fetchedStatus= statusServices.getStatusDetailsByStatusName(name);
        StatusDto statusDto=conertToStatusDto(fetchedStatus);
        return new ResponseEntity(statusDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllStatus(){
        List<Status> statuses= statusServices.getAllStatus();
        List<StatusDto> statusesDto=new ArrayList<>();
        for(int i=0;i<statuses.size();i++){
            statusesDto.add(conertToStatusDto(statuses.get(i)));
        }
        return new ResponseEntity(statusesDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteStatus(@PathVariable("id") int id){
        boolean res= statusServices.deleteStatus(id);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    private StatusDto conertToStatusDto(Status savedStatus) {
        StatusDto statusDto=new StatusDto(savedStatus.getStatusId(),savedStatus.getStatusName());
        return statusDto;
    }

    private Status convertToStatus(StatusDto statusDto) {
        Status status=new Status(statusDto.getStatusId(),statusDto.getStatusName());
        return status;
    }

}
