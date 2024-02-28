package com.kitabkaksha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitabkaksha.entity.Carts;
import com.kitabkaksha.service.CartService;

@CrossOrigin
@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/{bookId}")
	public ResponseEntity<Carts> addToCart(@PathVariable Integer bookId) {
		Carts cart = cartService.addToCart(bookId);
		return new ResponseEntity<Carts>(cart, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Carts> getCart() {
		Carts cart = cartService.getCart();
		return new ResponseEntity<Carts>(cart, HttpStatus.OK);
	}

	@DeleteMapping("/{bookId}")
	public ResponseEntity<Carts> removeFromCart(@PathVariable Integer bookId) {
		Carts cart = cartService.removeFromCart(bookId);
		return new ResponseEntity<Carts>(cart, HttpStatus.ACCEPTED);
	}

}
