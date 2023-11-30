
package com.kitabkaksha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@PatchMapping("/addtocart/{cartId}/{bookId}")
	public Carts addToCart(@PathVariable Integer cartId, @PathVariable Integer bookId) {
		return cartService.addToCart(cartId, bookId);
	}

	@PatchMapping("/removefromcart/{cartId}/{bookId}")
	public Carts removeFromCart(@PathVariable Integer cartId, @PathVariable Integer bookId) {
		return cartService.removeFromCart(cartId, bookId);
	}

	@GetMapping("/{cartId}")
	public Carts getCart(@PathVariable Integer cartId) {
		return cartService.getCartById(cartId);
	}
}
