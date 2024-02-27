package com.kitabkaksha.service;

import com.kitabkaksha.entity.Carts;

public interface CartService {
	public Carts createCart();

	public Carts getCart();

	public Carts addToCart(Integer bookId);

	public Carts removeFromCart(Integer bookId);
}
