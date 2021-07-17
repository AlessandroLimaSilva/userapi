package com.github.AlessandroLimaSilva.userapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.AlessandroLimaSilva.userapi.dto.mapper.UserMapper;
import com.github.AlessandroLimaSilva.userapi.dto.request.UserDTO;
import com.github.AlessandroLimaSilva.userapi.dto.response.MessageResponseDTO;
import com.github.AlessandroLimaSilva.userapi.entity.User;
import com.github.AlessandroLimaSilva.userapi.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

	private UserRepository userRepository;
	
	private final UserMapper userMapper = UserMapper.INSTANCE;
	
	
	
	public MessageResponseDTO create(UserDTO userDTO) {
		
		User user = userMapper.toModel(userDTO);
		User savedUser = userRepository.save(user);
		
		MessageResponseDTO messageResponse = 
				createMessageResponse("User successfully created with ID",savedUser.getId());
		
		return messageResponse;		
	}


	private MessageResponseDTO createMessageResponse(String s, Long id2) {
		return MessageResponseDTO.builder().message(s+id2).build();
	}


	public List<UserDTO> listAll() {
		List<User> allUser =userRepository.findAll();
		return allUser.stream().
				map(userMapper::toDTO).
				collect(Collectors.toList());
	}
}
