package com.github.AlessandroLimaSilva.userapi.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.AlessandroLimaSilva.userapi.dto.request.UserDTO;
import com.github.AlessandroLimaSilva.userapi.entity.User;


@Mapper(componentModel = "spring")
public interface UserMapper {
	
	//toModel Converte para bd
	@Mapping(target = "birthDate", source = "birtDate", dateFormat = "dd-MM-yyyy")
	User toModel(UserDTO dto);
	
	UserDTO toDTO(User dto);
}
