package com.github.AlessandroLimaSilva.userapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.AlessandroLimaSilva.userapi.dto.MessageResponseDTO;
import com.github.AlessandroLimaSilva.userapi.entity.User;
import com.github.AlessandroLimaSilva.userapi.repository.UserRepository;

@Service
public class UserService {

private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public MessageResponseDTO createUser(User user) {
		User savedUser = userRepository.save(user);
		
		return MessageResponseDTO.
				builder().
				message("Create user with ID "+savedUser.getId()).
				build();			
	}
}
