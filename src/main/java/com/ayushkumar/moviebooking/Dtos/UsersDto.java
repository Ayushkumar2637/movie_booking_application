package com.ayushkumar.moviebooking.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class UsersDto {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("date_of_birth")
    private LocalDateTime dateOfBirth;

    @JsonProperty("user_type_id")
    private int userTypeId;
    @JsonProperty("bookings_id")
    private List<Integer> bookingsId;
    @JsonProperty("lang_id")
    private int langId;

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public List<Integer> getBookingsId() {
        return bookingsId;
    }

    public void setBookingsId(List<Integer> bookingsId) {
        this.bookingsId = bookingsId;
    }

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public UsersDto() {
    }
    public UsersDto(int userId, String firstName, String lastName, String username, String password, LocalDateTime dateOfBirth) {
        this.userId = userId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.password=password;
        this.dateOfBirth=dateOfBirth;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "UsersDto{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", userTypeId=" + userTypeId +
                ", bookingsId=" + bookingsId +
                ", langId=" + langId +
                '}';
    }
}
