package com.ayushkumar.moviebooking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Language {
    @Id
    @GeneratedValue
    private int languageId;
    @Column(length = 20,nullable = false,unique = true)
    private String languageName;

    public Language(int languageId,String languageName) {
        this.languageId = languageId;
        this.languageName=languageName;
    }
    public Language(){}

    public int getLanguageId() {
        return languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}
