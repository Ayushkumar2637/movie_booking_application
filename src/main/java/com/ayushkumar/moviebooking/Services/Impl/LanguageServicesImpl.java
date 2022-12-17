package com.ayushkumar.moviebooking.Services.Impl;

import com.ayushkumar.moviebooking.Exception.LanguageDetailsNotFoundException;
import com.ayushkumar.moviebooking.Services.LanguageServices;
import com.ayushkumar.moviebooking.Daos.LanguageDao;
import com.ayushkumar.moviebooking.Entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServicesImpl implements LanguageServices {

    @Autowired
    private LanguageDao languageDao;

    @Override
    public Language acceptLanguageDetails(Language language) {
        return languageDao.save(language);
    }

    @Override
    public Language getLanguageDetailsById(int id) throws LanguageDetailsNotFoundException {
        Language language=languageDao.findById(id).orElseThrow(()->
                new LanguageDetailsNotFoundException("Language details not found for the language id : "+id));
        return language;
    }

    @Override
    public Language getLanguageDetailsByName(String name) throws LanguageDetailsNotFoundException {
        Language language=languageDao.findByLanguageNameIgnoreCase(name).orElseThrow(()->
                new LanguageDetailsNotFoundException("Language details not found for the language name : "+name));
        return language;
    }

    @Override
    public boolean deleteLanguage(int id) {
        languageDao.deleteById(id);
        return true;
    }

    @Override
    public List<Language> getAllLanguage() {
        return languageDao.findAll();
    }
}
