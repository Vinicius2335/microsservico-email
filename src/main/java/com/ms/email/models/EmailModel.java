package com.ms.email.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ms.email.enums.StatusEmail;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emailId;
	private String ownerRef; // aki fica o id do usuário que vai receber o email
	private String emailFrom; // quem está mandando o email
	private String emailTo; // quem recebe
	private String subject; // titulo do email
	
	@Column(columnDefinition = "TEXT")
	private String text; // corpo do email
	private LocalDateTime sendDateEmail; // data que foi enviado o email
	private StatusEmail statusEmail;
	
}
