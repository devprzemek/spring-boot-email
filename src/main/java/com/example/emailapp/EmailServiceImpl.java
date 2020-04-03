package com.example.emailapp;

import com.example.emailapp.dao.SubscriberRepository;
import com.example.emailapp.dao.models.entity.Movie;
import com.example.emailapp.manager.MovieManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Random;


@Service
public class EmailServiceImpl implements EmailSender{

    public JavaMailSender emailSender;
    private MovieManager movieManager;
    private SubscriberRepository subscriberRepository;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender, MovieManager movieManager, SubscriberRepository subscriberRepository) {
        this.emailSender = emailSender;
        this.movieManager = movieManager;
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public void sendSimpleMessage(String genre, String to){
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        List<Movie> accessibleMovies = movieManager.findByGenre(genre);
        final int  filmIndex = new Random().nextInt(accessibleMovies.size());
        final Movie movieToSend = accessibleMovies.get(filmIndex);

        try{
            createMessageHelper(mimeMessage, movieToSend, to);
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }

        emailSender.send(mimeMessage);
    }


    public MimeMessageHelper createMessageHelper(MimeMessage mimeMessage, Movie movieToSend,String to) throws MessagingException {
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setSubject("[FILM]");
        helper.setText("<body style=\"background-color:#484848;\">" +
                "<h1><font style=\"font-weight:bold; color:white\" size=\"7\"; face=\"helvetica\">\uD83C\uDF7F Oto Twoja propozycja \uD83C\uDFAC </font></h1>" +
                "<br><img src=\"" + movieToSend.getImageUrl() + "\"style=\"opacity: 1;\">" +
                "<p style=\"color:red; font-style: bold\"><font size=\"5\"; face=\"helvetica\"><em>" + "\"" + movieToSend.getTitle() + "\"" +
                "<br>" + movieToSend.getGenre() +
                "<br>" + movieToSend.getReleaseDate() +
                "<br>" +
                "<br>" + "#zostańwdomu" +
                "</em></font></p></body>", true);
        helper.addAttachment("info.txt", new ClassPathResource("static/info.txt"));

        return helper;
    }
}