package com.kitabkaksha.service;

import java.util.List;

import com.kitabkaksha.entity.Users;

public interface UserService {
	public Users createUser(Users user);

	public Users updateToAdmin(Users user);

	public Users getByUserId(Integer userId);

	public List<Users> getAllUser();

	public Users getUserByEmail(String name);
}
