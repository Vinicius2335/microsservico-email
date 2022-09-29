package com.ms.email.services;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.dtos.EmailDto;
import com.ms.email.enums.StatusEmail;
import com.ms.email.mappers.EmailMapper;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {
	private final EmailRepository emailRepository;
	private final JavaMailSender emailSender;

	// Amazon Simple Email Service
	// Serviço de email da Amazon é mais complexo

	@Transactional
	public EmailModel sendEmail(EmailDto emailDto) {
		EmailModel emailModel = EmailMapper.INSTANCE.toEmailModel(emailDto);
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
			return emailRepository.save(emailModel);
		}
	}
}
