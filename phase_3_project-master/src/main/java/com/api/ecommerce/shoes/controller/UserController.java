package com.api.ecommerce.shoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.shoes.exceptions.LoginException;
import com.api.ecommerce.shoes.exceptions.NoUserFoundException;
import com.api.ecommerce.shoes.exceptions.UserException;
import com.api.ecommerce.shoes.model.User;
import com.api.ecommerce.shoes.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/users")
	public ResponseEntity<User> addUser(@RequestBody User user) throws Exception{
		String tempEmailId = user.getUserEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj = userService.getByUserEmailId(tempEmailId);
			if(userobj != null) {
				throw new UserException();
			}
		}
		User userObj = null;
		userObj = userService.addUser(user);
		return new ResponseEntity<User>(userObj, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/users/{emailId}")
	public ResponseEntity<User> getByUserEmailId(@PathVariable("emailId") String emailId) throws Exception{
		User user = userService.getByUserEmailId(emailId);
		if(user == null) {
			throw new NoUserFoundException();
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping(value="/loginUser")
	public ResponseEntity<User> getByUserEmailIdAndUserPassword(@RequestBody User user) throws Exception {
		String tempEmailId = user.getUserEmailId();
		String tempPass = user.getUserPassword();
		User userObj = null;
		if (tempEmailId != null && tempPass != null) {
			userObj = userService.getByUserEmailIdAndUserPassword(tempEmailId, tempPass);			
		}
		if (userObj == null) {
			throw new LoginException();
		}
		return new ResponseEntity<User>(userObj, HttpStatus.OK);
	}
}
