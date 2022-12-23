package com.ms.email.domain.models;

import com.ms.email.domain.enums.StatusEmail;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Type(type = "uuid-char")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "varchar(36)")
	private UUID emailId;
	private String ownerRef; // aki fica o id do usuário que vai receber o email
	private String emailFrom; // quem está mandando o email
	private String emailTo; // quem recebe
	private String subject; // titulo do email
	
	@Column(columnDefinition = "TEXT")
	private String text; // corpo do email
	private LocalDateTime sendDateEmail; // data que foi enviado o email
	private StatusEmail statusEmail;
	
}
