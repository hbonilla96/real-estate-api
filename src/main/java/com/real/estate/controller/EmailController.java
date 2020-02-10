package com.real.estate.controller;

import com.real.estate.model.Email;
import com.real.estate.services.implementation.EmailServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/email")
@Controller
public class EmailController {

    private EmailServiceImpl emailService;

    public EmailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public String sendEmail(@RequestBody Email email) throws MessagingException{
        emailService.sendEmail(email.getRecipient(), email.getSubject(),email.getEmail());
        return "email sent";
    }
}
