package com.ayushkumar.moviebooking.Services;

import com.ayushkumar.moviebooking.Exception.LanguageDetailsNotFoundException;
import com.ayushkumar.moviebooking.Entity.Language;

import java.util.List;

public interface LanguageServices {
    public Language acceptLanguageDetails(Language language);
    public Language getLanguageDetailsById(int id) throws LanguageDetailsNotFoundException;
    public Language getLanguageDetailsByName(String name) throws LanguageDetailsNotFoundException;
    public boolean deleteLanguage(int id);
    public List<Language> getAllLanguage();
}
