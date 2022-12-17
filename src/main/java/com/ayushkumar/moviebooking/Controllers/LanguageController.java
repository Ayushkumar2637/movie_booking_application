package com.ayushkumar.moviebooking.Controllers;

import com.ayushkumar.moviebooking.Dtos.LanguageDto;
import com.ayushkumar.moviebooking.Exception.InvalidLanguageRequestBodyException;
import com.ayushkumar.moviebooking.Exception.LanguageDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.LanguageServices;
import com.ayushkumar.moviebooking.Entity.Language;
import com.ayushkumar.moviebooking.Validators.LanguageDtoValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageServices languageServices;

    @PostMapping
    public ResponseEntity createLanguage(@RequestBody LanguageDto languageDto) throws InvalidLanguageRequestBodyException {
        LanguageDtoValidators.isValid(languageDto);
        Language language = convertToLanguage(languageDto);
        Language savedLanguage = languageServices.acceptLanguageDetails(language);
        LanguageDto languageDto1 = convertToLanguageDto(savedLanguage);
        return new ResponseEntity(languageDto1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{name}")
    public ResponseEntity getLanguageByName(@PathVariable("name") String langName) throws LanguageDetailsNotFoundException {
        Language fetchedLanguage= languageServices.getLanguageDetailsByName(langName);
        LanguageDto languageDto=convertToLanguageDto(fetchedLanguage);
        return new ResponseEntity(languageDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllLanguage(){
        List<Language> lang= languageServices.getAllLanguage();
        List<LanguageDto> langDto=new ArrayList<>();
        for(int i=0;i<lang.size();i++){
            langDto.add(convertToLanguageDto(lang.get(i)));
        }
        return new ResponseEntity(langDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLanguage(@PathVariable("id") int id){
        boolean res= languageServices.deleteLanguage(id);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    private LanguageDto convertToLanguageDto(Language savedLanguage) {
        LanguageDto languageDto=new LanguageDto(savedLanguage.getLanguageId(),savedLanguage.getLanguageName());
        return languageDto;
    }

    private Language convertToLanguage(LanguageDto languageDto) {
        Language language=new Language(languageDto.getLanguageId(),languageDto.getLanguageName());
        return language;
    }

}
