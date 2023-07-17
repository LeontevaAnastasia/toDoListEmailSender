package com.taskListEmailSender.toDoListEmailSender.service.rabbitmq;

import com.taskListEmailSender.toDoListEmailSender.service.Mailer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taskListEmailSender.toDoListEmailSender.to.EmailTo;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@AllArgsConstructor
public class RabbitConsumer {

   private Mailer mailer;
    protected final Logger logger = LoggerFactory.getLogger(getClass());


        @RabbitListener(queues = "${rabbit.queue}")
        public void consumeMessage(String messages) {

            handle(messages);
        }



    public void handle(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        EmailTo emailMessages = new EmailTo();
        try {
            emailMessages = objectMapper.readValue(message, EmailTo.class);
        } catch ( JsonProcessingException e) {
            logger.info("JSON parsing failed: {}", message);
        }
      //  for (EmailTo emailMessage: emailMessages) {
            String emailAddress = emailMessages.getRecipientAddress();
            try {
                mailer.send(emailAddress, emailMessages.getTitle(), emailMessages.getText());
                logger.info("Email has been sent to address: {}", emailMessages.getRecipientAddress());
            } catch (Exception exception) {
                logger.error("Email sending to address {} failed. {}",
                        emailAddress, exception.getMessage());
            }
      //  }
    }

}
