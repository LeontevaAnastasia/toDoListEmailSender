package com.taskListEmailSender.toDoListEmailSender.service;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmailService {

    @Value("${sender.address}")
    private String senderAddress;

    private JavaMailSender emailSender;

    public void sendMessage(String recipientAddress, String title, String text) {
        SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom(senderAddress);
        simpleMail.setTo(recipientAddress);
        simpleMail.setSubject(title);
        simpleMail.setText(text);
        emailSender.send(simpleMail);
    }
}
