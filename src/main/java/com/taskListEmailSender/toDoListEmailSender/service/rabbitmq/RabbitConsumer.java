package com.taskListEmailSender.toDoListEmailSender.service.rabbitmq;

import com.taskListEmailSender.toDoListEmailSender.model.dto.EmailDto;
import com.taskListEmailSender.toDoListEmailSender.service.ConsumerHandler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RabbitConsumer {

    private ConsumerHandler consumerHandler;

        @RabbitListener(queues = "${rabbit.queue}")
        public void consumeMessage(List<EmailDto> messages) {
            consumerHandler.handle(messages);
        }



}
