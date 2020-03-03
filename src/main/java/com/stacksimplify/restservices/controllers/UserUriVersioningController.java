package com.stacksimplify.restservices.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.dtos.UserDtoV1;
import com.stacksimplify.restservices.dtos.UserDtoV2;
import com.stacksimplify.restservices.dtos.UserMmDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;

@RestController
@RequestMapping("/versioning/params/users")
public class UserUriVersioningController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;
	//URI Based vaerioning - Version1 
	@GetMapping(value =  "/{id}", params="version=1")
	public UserDtoV1 getUserById(@PathVariable(name = "id") @Min(1) Long id) throws UserNotFoundException{
		
		Optional<User> userOptional=userService.getUserById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		User user = userOptional.get();
		
		UserDtoV1 userDtoV1=modelMapper.map(user, UserDtoV1.class);
		return userDtoV1;
			
	}
	//URI Based vaerioning - Version2 
	@GetMapping(value =  "/{id}", params="version=2")
	public UserDtoV2 getUserById2(@PathVariable(name = "id") @Min(1) Long id) throws UserNotFoundException{
			
		Optional<User> userOptional=userService.getUserById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		User user = userOptional.get();
			
		UserDtoV2 userDtoV2=modelMapper.map(user, UserDtoV2.class);
		return userDtoV2;
				
	}

}
