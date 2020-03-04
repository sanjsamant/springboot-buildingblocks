package com.stacksimplify.restservices.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.exceptions.UsernameNotFoundException;
import com.stacksimplify.restservices.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Validated
@RequestMapping("/users")
@Api(tags = "User Management RESTful Services", value = "UserController", description = "Controller for User Management Service")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	@ApiOperation(value = "Create a new user")
	public ResponseEntity<Void> createUser(@ApiParam("User information for a new user to be created.") @Valid @RequestBody User user, ServletUriComponentsBuilder builder) {
		try{
			user=userService.createUser(user);
			HttpHeaders headers=new HttpHeaders();
			URI uri= builder.fromCurrentContextPath()
					.path("/{id}")
					.buildAndExpand(user.getUserid())
					.toUri();
			headers.setLocation(uri);
			return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		}catch(UserExistsException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(name = "id") @Min(1) Long id){
		try {
			 return (userService.getUserById(id)).get();
			
			
		}catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable Long id, @RequestBody User user) {
		try{
			return userService.updateUserById(id, user);
		}catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		   userService.deleteUserById(id);
	}
	@GetMapping("/byusername/{username}")
	public User getUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("Username :'"+username+"' not found in User repository");
		return user;
	}
}
