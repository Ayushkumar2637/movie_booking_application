package com.ayushkumar.moviebooking.Validators;

import com.ayushkumar.moviebooking.Dtos.LanguageDto;
import com.ayushkumar.moviebooking.Exception.InvalidLanguageRequestBodyException;

public class LanguageDtoValidators {
    public static boolean isValid(LanguageDto languageDto) throws InvalidLanguageRequestBodyException {
        if(languageDto.getLanguageName()==null || languageDto.getLanguageName().equals(""))
            throw new InvalidLanguageRequestBodyException("Language name is empty or null");
        return true;
    }
}
