package com.ayushkumar.moviebooking.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class MovieDto {

    @JsonProperty("movie_id")
    private int movieId;
    @JsonProperty("movie_name")
    private String movieName;
    @JsonProperty("movie_desc")
    private String movieDescription;
    @JsonProperty("release_date")
    private LocalDateTime releaseDate;
    @JsonProperty("duration")
    private double duration;
    @JsonProperty("cover_photo_url")
    private String coverPhotoUrl;
    @JsonProperty("trailer_url")
    private String trailerUrl;

    @JsonProperty("status_id")
    private int statusId;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public MovieDto(){}

    public MovieDto(int movieId, String movieName, String movieDescription, LocalDateTime releaseDate, double duration, String coverPhotoUrl, String trailerUrl) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.coverPhotoUrl = coverPhotoUrl;
        this.trailerUrl = trailerUrl;
    }

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
        return "MovieDto{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", statusId='" + statusId  + '\''  +
                '}';
    }
}
