package com.stacksimplify.restservices.controllers;


import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.mappers.UserMapper;
import com.stacksimplify.restservices.repositories.UserRepository;
import com.stacksimplify.restservices.services.UserService;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping 
	public List<UserMsDto> getAllUserDtos(){
		return userMapper.usersToUserMsDtos(userRepository.findAll());
		
	}
	@GetMapping("/{id}")
	public UserMsDto getUserById(@PathVariable(name = "id")Long id){

		Optional<User> userOptional=userRepository.findById(id);
		
		User user=userOptional.get();
		return userMapper.usertoUserMsDto(user);
	}
	
}
