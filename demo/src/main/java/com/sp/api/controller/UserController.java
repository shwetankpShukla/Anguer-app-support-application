package com.sp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.api.domain.User;
import com.sp.api.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/login",produces = "application/json")
	public boolean validateUser(@RequestBody User user) {
		log.info("UserController --> validateUser user id :{}",user.getUserId());
		return userService.validateUser(user);
	}

}
