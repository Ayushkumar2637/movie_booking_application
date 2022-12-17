package com.ayushkumar.moviebooking.Daos;

import com.ayushkumar.moviebooking.Entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageDao extends JpaRepository<Language,Integer> {
    public Optional<Language> findByLanguageNameIgnoreCase(String languageName);
}
