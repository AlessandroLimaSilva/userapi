package com.github.AlessandroLimaSilva.userapi.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.github.AlessandroLimaSilva.userapi.dto.request.UserDTO;
import com.github.AlessandroLimaSilva.userapi.entity.User;


@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "birthDate", source = "birthdate", dateFormat = "dd-MM-yyyy")
	User toModel(UserDTO dto);
	
	UserDTO toDTO(User dto);
}
