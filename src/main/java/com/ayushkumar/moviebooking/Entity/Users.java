package com.ayushkumar.moviebooking.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name="first_name",length = 20,nullable = false)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column(length = 20,nullable = false,unique = true)
    private String username;
    @Column(length = 20,nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDateTime dateOfBirth;

    // some other codes too in github for mobile no

    @ManyToOne
    @JoinColumn(name="userType_Id")
    private UserType usertype;
    @OneToMany(mappedBy = "users") // some other constrains too
    private List<Booking> booking;
    @ManyToOne
    @JoinColumn(name="Language_Id")
    private Language language;

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Users(int userId, String firstName, String lastName, String username, String password, LocalDateTime dateOfBirth) {
        this.userId = userId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.password=password;
        this.dateOfBirth=dateOfBirth;
    }
    public Users(){}

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
        return "Users{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
