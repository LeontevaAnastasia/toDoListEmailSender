package com.taskListEmailSender.toDoListEmailSender.service;

public class Mailer {

    EmailService emailService;

    public void send(String recipientAddress, String title, String text) {
        emailService.sendMessage(recipientAddress, title, text);
    }
}
