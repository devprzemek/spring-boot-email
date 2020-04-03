package com.example.emailapp.manager;

import com.example.emailapp.dao.SubscriberRepository;
import com.example.emailapp.dao.models.entity.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriberManager {
    private SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberManager(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public List<Subscriber> findAll(){
        return subscriberRepository.findAll();
    }

    public Subscriber save(Subscriber subscriber){
        List<String> presentSubscribers = findAll().stream().map(element -> element.getEmailAddress()).collect(Collectors.toList());

        if(!presentSubscribers.contains(subscriber.getEmailAddress())){
            return subscriberRepository.save(subscriber);
        }
        return subscriber;
    }

}
