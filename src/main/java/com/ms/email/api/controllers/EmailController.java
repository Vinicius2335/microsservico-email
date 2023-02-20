package com.ms.email.api.controllers;

import javax.validation.Valid;

import com.ms.email.api.representation.model.EmailRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ms.email.domain.models.EmailModel;
import com.ms.email.domain.services.EmailService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping
@RequiredArgsConstructor
@Log4j2
public class EmailController {
	private final EmailService emailService;

	@GetMapping("/emails")
	public ResponseEntity<Page<EmailModel>> getAllEmails(@PageableDefault(page = 0, size = 5, sort = "emailId",
			direction = Sort.Direction.ASC) Pageable pageable){

		log.trace("TRACE");
		log.debug("DEBUG");
		log.info("INFO");
		log.warn("WARN");
		log.error("ERROR");
		log.fatal("FATAL");

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(emailService.getAllEmails(pageable));
	}
	
	@PostMapping("/sending-email")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailRequest emailRequest){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(emailService.sendEmail(emailRequest));
	}
}
