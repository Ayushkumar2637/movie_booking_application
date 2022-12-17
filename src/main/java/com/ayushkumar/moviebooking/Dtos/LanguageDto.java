package com.ayushkumar.moviebooking.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageDto {

    @JsonProperty("lang_id")
    private int languageId;
    @JsonProperty("lang_name")
    private String languageName;

    public LanguageDto() {
    }

    public LanguageDto(int languageId,String languageName) {
        this.languageId = languageId;
        this.languageName=languageName;
    }

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
        return "LanguageDto{" +
                "languageId=" + languageId +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}
