package com.kitabkaksha.service;

import com.kitabkaksha.entity.Carts;

public interface CartService {
	public Carts createCart(Carts cart);

	public Carts getCartById(Integer cartId);

	public Carts addToCart(Integer cartId, Integer bookId);

	public Carts removeFromCart(Integer cartId, Integer bookId);

}
