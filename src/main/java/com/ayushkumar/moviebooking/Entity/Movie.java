package com.ayushkumar.moviebooking.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Table(name="Cinema")

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;
    @Column(length = 50,nullable = false)
    private String movieName;
    @Column(name="movieDesc",length = 500,nullable = false)
    private String movieDescription;
    @Column(nullable = false)
    private LocalDateTime releaseDate;
    @Column(nullable = false)
    private double duration;
    @Column(length = 500,nullable = false)
    private String coverPhotoUrl;
    @Column(length = 500,nullable = false)
    private String trailerUrl;

    // Unidirectional
    @ManyToOne
    @JoinColumn(name="Status_Id")
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Movie(int movieId, String movieName, String movieDescription, LocalDateTime releaseDate, double duration, String coverPhotoUrl, String trailerUrl) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.coverPhotoUrl = coverPhotoUrl;
        this.trailerUrl = trailerUrl;
    }
    // This is imp constructer in order to execute above constructer , @GenerateValue in proper maner
    public Movie(){}

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public double getDuration() {
        return duration;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }


    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                '}';
    }
}
