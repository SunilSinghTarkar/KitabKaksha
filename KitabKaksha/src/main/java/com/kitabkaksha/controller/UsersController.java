package com.kitabkaksha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitabkaksha.entity.Users;
import com.kitabkaksha.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/registers")
	public Users addUser(@Valid @RequestBody Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
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
	
	@GetMapping("/signIn")
	public ResponseEntity<Users> getCustomerByEmail(Authentication auth) {

		log.info("Inside getCustomerByEmail method of user controller");
		System.out.println("username: " + auth.getName());
		Users user = userService.getUserByEmail(auth.getName());

		return new ResponseEntity<Users>(user, HttpStatus.ACCEPTED);
	}
}
