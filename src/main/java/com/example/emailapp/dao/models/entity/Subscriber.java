package com.example.emailapp.dao.models.entity;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Subscriber {

    @Id
    private String id;

    @NotNull
    @Email(message = "Invalid email!")
    private String emailAddress;

    public Subscriber() {
    }

    public Subscriber(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id='" + id + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
