package com.kitabkaksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitabkaksha.entity.Carts;
import com.kitabkaksha.entity.Users;
import com.kitabkaksha.exception.NotFoundException;
import com.kitabkaksha.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CartService cartService;

	@Override
	public Users createUser(Users user) {
		// TODO Auto-generated method stub
		user.setVarified(false);
		user.setActive(true);
		int num = (int) (Math.random() * 1000);
		user.setOtp(num + 1000);
		Carts cart = cartService.createCart(new Carts());
		user.setCart(cart);
		return userRepo.save(user);
	}

	@Override
	public Users getByUserId(Integer userId) {
		Users user = userRepo.findById(userId).orElseThrow(() -> new NotFoundException("User not found!"));
		return user;
	}

	@Override
	public List<Users> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public boolean varifyOtp(Integer userId, Integer otp) {
		// TODO Auto-generated method stub
		return false;
	}

}
