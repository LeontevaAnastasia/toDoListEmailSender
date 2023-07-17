package com.taskListEmailSender.toDoListEmailSender.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${sender.address}")
    private String senderAddress;
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMessage(String recipientAddress, String title, String text) {
        SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom(senderAddress);
        simpleMail.setTo(recipientAddress);
        simpleMail.setSubject(title);
        simpleMail.setText(text);
        mailSender.send(simpleMail);
    }
}
