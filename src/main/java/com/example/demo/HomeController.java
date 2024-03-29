package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animal")
public class HomeController {
    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping()
    public String lowFive(@ModelAttribute("messageForm")   MessageForm messageForm, Model model) {
        messageListService.addMessage("Welcome, Grasshopper.");
        model.addAttribute("greetings", messageListService.getMessages());
        return "home";
    }

    @PostMapping()
    public String highFive(@ModelAttribute("messageForm")  MessageForm messageForm, Model model) {

        messageListService.addMessage("We shall now study the " + messageForm.getAdjective() + " " + messageForm.getAnimalName() + " style.");
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setAnimalName("");
        messageForm.setAdjective("");
        return "animal";
    }
}