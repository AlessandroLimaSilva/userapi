package com.github.AlessandroLimaSilva.userapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.AlessandroLimaSilva.userapi.dto.request.UserDTO;
import com.github.AlessandroLimaSilva.userapi.dto.response.MessageResponseDTO;
import com.github.AlessandroLimaSilva.userapi.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
	
	private final UserService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createUser(@RequestBody @Valid UserDTO userDTO) {
		return userService.createUser(userDTO);	
	}

	@GetMapping
	public List<UserDTO> listaAll(){
		return userService.listAll();
	}
}
