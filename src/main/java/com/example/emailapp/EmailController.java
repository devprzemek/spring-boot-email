package com.example.emailapp;

import com.example.emailapp.dao.models.MovieGenre;
import com.example.emailapp.dao.models.entity.Movie;
import com.example.emailapp.dao.models.entity.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {
    private final EmailSender emailSender;
    private String movieGenre;

    @Autowired
    public EmailController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @RequestMapping(value = "email/{sendTo}", method = RequestMethod.GET)
    public String send(@PathVariable("sendTo") String sendTo){
        emailSender.sendSimpleMessage(movieGenre, sendTo);
        return "redirect:/template";
    }

    @RequestMapping(value = "template", method = RequestMethod.GET)
    public String getTemplate(Model model){
        model.addAttribute(new Movie());
        model.addAttribute("movieGenres", MovieGenre.values());
        return "pageTemplate";
    }

    @RequestMapping(value = "submit", method = RequestMethod.GET)
    public String displayEmailForm(@ModelAttribute Movie movie, Model model){
        movieGenre = movie.getGenre();
        model.addAttribute(new Subscriber());
        return "verifyTemplate";
    }
}
