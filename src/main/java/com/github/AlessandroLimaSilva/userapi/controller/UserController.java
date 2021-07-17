package com.github.AlessandroLimaSilva.userapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.github.AlessandroLimaSilva.userapi.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
	public MessageResponseDTO create(@RequestBody @Valid UserDTO userDTO) {

		return userService.create(userDTO);
	}

	@GetMapping
	public List<UserDTO> listaAll(){
		return userService.listAll();
	}

	@GetMapping("{/id}")
	public UserDTO findById(@PathVariable Long id) throws UserNotFoundException {
		return userService.findById(id);
	}

	@DeleteMapping("{/id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws UserNotFoundException {
		userService.delete(id);
	}
}
