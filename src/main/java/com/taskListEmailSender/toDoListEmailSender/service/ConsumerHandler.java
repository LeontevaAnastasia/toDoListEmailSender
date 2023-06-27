package com.taskListEmailSender.toDoListEmailSender.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taskListEmailSender.toDoListEmailSender.model.dto.EmailDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerHandler {

    private Mailer mailer;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

        public void handle(List <EmailDto> messages) {
            for (EmailDto emailMessage: messages) {
                String emailAddress = emailMessage.getRecipientAddress();
                try {
                    mailer.send(emailAddress, emailMessage.getTitle(), emailMessage.getText());
                    logger.info("Email has been sent to address: ${emailMessage.recipientAddress}");
                } catch (Exception exception) {
                    logger.error("Email sending to address \"$emailAddress\" failed. ${e.message}");
                }
            }
        }



}
