package com.example.emailapp.dao.models.entity;

import org.springframework.data.annotation.Id;
import java.time.LocalDate;

public class Movie {

    @Id
    private String id;

    private String title;
    private String genre;
    private LocalDate releaseDate;
    private String imageUrl;

    public Movie() {
    }

    public Movie(String title, String genre, LocalDate releaseDate, String imageUrl) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + releaseDate +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
