package com.oms.cart.cartservice.service;

import com.oms.cart.cartservice.model.Cart;
import com.oms.cart.cartservice.model.Products;

public interface Cartservice {

	public Products[] getAllProducts();

	public void addToCart(String username, String password, int cartId);
	
	public Cart getAllCartByID(int cartId);

	public Cart removeProductFromCart(int cartId, int productID);
}
