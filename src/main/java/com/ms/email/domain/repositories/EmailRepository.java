package com.ms.email.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.email.domain.models.EmailModel;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Long> {
	
}
