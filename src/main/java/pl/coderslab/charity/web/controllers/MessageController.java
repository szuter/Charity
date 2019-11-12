package pl.coderslab.charity.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.dto.MessageDTO;
import pl.coderslab.charity.sevices.EmailService;

import java.security.Principal;

@Controller
public class MessageController {


    private EmailService emailService;

    public MessageController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/message")
    public String processSendMessagePage(@RequestParam String name, @RequestParam String surname, @RequestParam String message, Principal principal) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setFirstName(name);
        messageDTO.setLastName(surname);
        messageDTO.setMessage(message);
        if (principal != null)
            messageDTO.setEmail(principal.getName());
        emailService.sendSimpleMessage(messageDTO);
        return "redirect:/";
    }
}
