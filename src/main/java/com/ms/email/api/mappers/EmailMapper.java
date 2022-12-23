package com.ms.email.api.mappers;

import com.ms.email.api.representation.model.EmailRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ms.email.domain.models.EmailModel;

@Mapper
public abstract class EmailMapper {
	public static final EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);
	
	public abstract EmailModel toEmailModel(EmailRequest emailRequest);
}
