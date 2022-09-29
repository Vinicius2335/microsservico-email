package com.ms.email.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ms.email.dtos.EmailDto;
import com.ms.email.models.EmailModel;

@Mapper
public abstract class EmailMapper {
	public static final EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);
	
	public abstract EmailModel toEmailModel(EmailDto emailDto);
}
