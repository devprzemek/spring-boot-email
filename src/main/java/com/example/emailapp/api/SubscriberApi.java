package com.example.emailapp.api;

import com.example.emailapp.dao.models.entity.Subscriber;
import com.example.emailapp.manager.SubscriberManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SubscriberApi {
    private SubscriberManager subscriberManager;

    public SubscriberApi(SubscriberManager subscriberManager) {
        this.subscriberManager = subscriberManager;
    }

    @RequestMapping(value = "process-subscriber", method = RequestMethod.POST)
    public String processAddSubscriber(@ModelAttribute @Valid Subscriber subscriber, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("subscriber", subscriber);
            return "verifyTemplate";
        }
        subscriberManager.save(subscriber);
        return "redirect:/email/" + subscriber.getEmailAddress();
    }

}
