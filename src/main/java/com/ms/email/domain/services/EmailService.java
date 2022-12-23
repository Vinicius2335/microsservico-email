package com.ms.email.domain.services;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import com.ms.email.api.representation.model.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.domain.enums.StatusEmail;
import com.ms.email.api.mappers.EmailMapper;
import com.ms.email.domain.models.EmailModel;
import com.ms.email.domain.repositories.EmailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailRepository emailRepository;
    private final JavaMailSender emailSender;

    // Amazon Simple Email Service
    // Serviço de email da Amazon é mais complexo

    @Transactional
    public EmailModel sendEmail(EmailRequest emailRequest) {
        EmailModel emailSaved;
        EmailModel emailModel = EmailMapper.INSTANCE.toEmailModel(emailRequest);
        emailModel.setSendDateEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);

        } catch (Exception e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
            e.printStackTrace();

        } finally {
            emailSaved = emailRepository.save(emailModel);
        }
        return emailSaved;
    }
}
