package com.kitabkaksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitabkaksha.entity.Carts;
import com.kitabkaksha.entity.Users;
import com.kitabkaksha.exception.NotFoundException;
import com.kitabkaksha.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersRepository userRepo;
	@Autowired
	private CartService cartService;

	@Override
	public Users createUser(Users user) {
		user.setActive(true);
		Carts cart = cartService.createCart();
		user.setCart(cart);
		return userRepo.save(user);

	}

	@Override
	public Users updateToAdmin(Users user) {
		Users updated = userRepo.save(user);
		return updated;
	}

	@Override
	public Users getByUserId(Integer userId) {
		Users user = userRepo.findById(userId).orElseThrow(() -> new NotFoundException("User not found!"));
		return user;
	}

	@Override
	public List<Users> getAllUser() {

		return userRepo.findAll();
	}

	@Override
	public Users getUserByEmail(String email) {
		Users user = userRepo.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("User not found with given email: " + email));
		return user;
	}

}
