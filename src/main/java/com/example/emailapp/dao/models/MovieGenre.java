package com.example.emailapp.dao.models;

public enum MovieGenre {
    ACTION("Akcji"),
    DRAMA("Dramat"),
    HISTORICAL("Historyczny"),
    HORROR("Horror"),
    COMEDY("Komedia"),
    CRIME("Kryminał"),
    SCI_FI("Sci-Fi"),
    THRILLER("Thriller"),
    WESTERN("Western");

    private final String name;

    MovieGenre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
