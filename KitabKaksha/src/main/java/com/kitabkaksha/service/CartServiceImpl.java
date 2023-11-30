package com.kitabkaksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitabkaksha.entity.Books;
import com.kitabkaksha.entity.Carts;
import com.kitabkaksha.exception.NotFoundException;
import com.kitabkaksha.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private BookService bookService;

	@Override
	public Carts createCart(Carts cart) {

		return cartRepo.save(cart);
	}

	@Override
	public Carts addToCart(Integer cartId, Integer bookId) {
		Books book = bookService.getBookById(bookId);
		Carts cart = getCartById(cartId);
		cart.getBookList().add(book);
		return cartRepo.save(cart);
	}

	@Override
	public Carts removeFromCart(Integer cartId, Integer bookId) {
		Books book = bookService.getBookById(bookId);
		Carts cart = getCartById(cartId);
		List<Books> list=cart.getBookList();
		list.remove(book);
		cart.setBookList(list);
		return cartRepo.save(cart);
	}

	@Override
	public Carts getCartById(Integer cartId) {
		Carts cart = cartRepo.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not found!"));
		return cart;
	}

}
