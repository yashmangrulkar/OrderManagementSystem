package com.oms.user.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oms.user.userservice.model.User;
import com.oms.user.userservice.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/login/{username}/{password}")
	public User loginUser(@PathVariable(value = "username") String username,
			@PathVariable(value = "password") String password) {
		User userList = userService.userLogin(username, password);

		return userList;

	}
}
