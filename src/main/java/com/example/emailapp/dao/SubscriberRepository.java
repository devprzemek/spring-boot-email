package com.example.emailapp.dao;

import com.example.emailapp.dao.models.entity.Subscriber;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriberRepository extends MongoRepository<Subscriber, String> {
}
