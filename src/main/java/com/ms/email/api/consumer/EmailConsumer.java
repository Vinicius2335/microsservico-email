package com.ms.email.api.consumer;

import com.ms.email.api.representation.model.EmailRequest;
import com.ms.email.domain.models.EmailModel;
import com.ms.email.domain.services.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailConsumer {
    private final EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailRequest emailRequest) {
        EmailModel emailModel = emailService.sendEmail(emailRequest);
        log.info("Email Status: {}", emailModel.getStatusEmail().toString());
    }
}
