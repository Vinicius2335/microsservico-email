package com.ms.email.api.controllers;

import javax.validation.Valid;

import com.ms.email.api.representation.model.EmailRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.email.domain.models.EmailModel;
import com.ms.email.domain.services.EmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmailController {
	private final EmailService emailService; 
	
	@PostMapping("/sending-email")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailRequest emailRequest){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(emailService.sendEmail(emailRequest));
	}
}
