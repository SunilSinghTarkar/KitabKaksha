package com.kitabkaksha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitabkaksha.entity.Users;
import com.kitabkaksha.exception.NotFoundException;
import com.kitabkaksha.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/registers")
	public Users addUser(@Valid @RequestBody Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_ADMIN");
		try {
			Users checkUser = userService.getUserByEmail(user.getEmail());
			if (checkUser != null) {
				checkUser.setRole("ROLE_ADMIN");
				checkUser.setPassword(user.getPassword());
				Users updatedUser = userService.updateToAdmin(checkUser);
				return updatedUser;
			}
		} catch (NotFoundException error) {
			error.getStackTrace();
		}

		return userService.createUser(user);
	}

}
