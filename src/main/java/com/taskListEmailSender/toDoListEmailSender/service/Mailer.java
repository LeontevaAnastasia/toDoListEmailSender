package com.taskListEmailSender.toDoListEmailSender.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Mailer {

    EmailService emailService;

    public void send(String recipientAddress, String title, String text) {
        emailService.sendMessage(recipientAddress, title, text);
    }
}
