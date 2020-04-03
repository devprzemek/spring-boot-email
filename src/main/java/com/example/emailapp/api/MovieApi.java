package com.example.emailapp.api;

import com.example.emailapp.dao.models.entity.Movie;
import com.example.emailapp.manager.MovieManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieApi {
    private MovieManager movieManager;

    public MovieApi(MovieManager movieManager) {
        this.movieManager = movieManager;
    }

    @GetMapping("/all")
    public Iterable<Movie> getAll(){
        return movieManager.findAll();
    }

    @PostMapping("/add-movie")
    public Movie addMovie(@RequestBody Movie movie){
        return movieManager.save(movie);
    }

}
