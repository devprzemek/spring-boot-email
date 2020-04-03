package com.example.emailapp.manager;

import com.example.emailapp.dao.models.entity.Movie;
import com.example.emailapp.dao.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieManager {
    private MovieRepository movieRepository;

    @Autowired
    public MovieManager(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie save(Movie movie){
        return movieRepository.save(movie);
    }

    public Iterable<Movie> findAll(){
        return movieRepository.findAll();
    }

    public List<Movie> findByGenre(String genre){
        return movieRepository.findAll().stream().filter(element -> element.getGenre().contains(genre)).collect(Collectors.toList());
    }
}
