package com.kitabkaksha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitabkaksha.entity.Users;
import com.kitabkaksha.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserService userService;

	@PostMapping("/registers")
	public Users addUser(@RequestBody Users user) {
		user.setRole("ROLE_USER");
		return userService.createUser(user);
	}

	@GetMapping("/{userId}")
	public Users getUserById(@PathVariable Integer userId) {
		return userService.getByUserId(userId);
	}

	@GetMapping
	public List<Users> getAllUser() {
		return userService.getAllUser();
	}
}
