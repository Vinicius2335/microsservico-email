package com.ms.email.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.email.dtos.EmailDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmailController {
	private final EmailService emailService; 
	
	@PostMapping("/sending-email")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(emailService.sendEmail(emailDto));
	}
}
