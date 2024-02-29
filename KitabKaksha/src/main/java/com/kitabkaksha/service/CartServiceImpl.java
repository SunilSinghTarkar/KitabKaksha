package com.kitabkaksha.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.kitabkaksha.entity.Books;
import com.kitabkaksha.entity.Carts;
import com.kitabkaksha.entity.Users;
import com.kitabkaksha.exception.NotFoundException;
import com.kitabkaksha.repository.CartsRepository;
import com.kitabkaksha.repository.UsersRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartsRepository cartRepo;
	@Autowired
	private BookService bookService;
	@Autowired
	private UsersRepository userRepo;

	@Override
	public Carts createCart() {
		Carts cart = new Carts();
		return cartRepo.save(cart);
	}

	@Override
	public Carts addToCart(Integer bookId) {
		Books book = bookService.getBookById(bookId);
		Carts cart = getCart();
		cart.getBookList().add(book);
		return cartRepo.save(cart);
	}

	@Override
	public Carts removeFromCart(Integer bookId) {
		Books book = bookService.getBookById(bookId);
		Carts cart = getCart();
		Set<Books> list = cart.getBookList();
		list.remove(book);
		cart.setBookList(list);
		return cartRepo.save(cart);
	}

	@Override
	public Carts getCart() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		Users user = userRepo.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found!"));
		Carts cart = user.getCart();
		return cart;
	}
}
