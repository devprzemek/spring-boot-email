package com.example.emailapp.dao;

import com.example.emailapp.dao.models.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
