package com.oms.cart.cartservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oms.cart.cartservice.model.Cart;
import com.oms.cart.cartservice.service.Cartservice;

@RestController
public class CartController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Cartservice cartservice;

	// Get all the products
	@GetMapping("/allproductslist")
	public void GetAllProducts() {

		cartservice.getAllProducts();

	}

	// Adding products to the cart
	@GetMapping("/addtocart/{username}/{password}/{cartId}")
	public void addCart(@PathVariable String username, @PathVariable String password, @PathVariable int cartId) {

		logger.info("{}", "In Add Cart Method");

		cartservice.addToCart(username, password, cartId);

	}

	// Adding products to the cart via Feign
	@GetMapping("/addtocart-feign/{username}/{password}/{cartId}")
	public void addCartFeign(@PathVariable String username, @PathVariable String password, @PathVariable int cartId) {

		logger.info("{}", "In Add Cart Feign Method");

		cartservice.addToCartFeign(username, password, cartId);

	}

	// Remove From Cart
	@GetMapping("/removefromcart/{cartId}/{productID}")
	public Cart removeFromCart(@PathVariable int cartId, @PathVariable int productID) {
		return cartservice.removeProductFromCart(cartId, productID);
	}

	@GetMapping("/fetchCart/{cartId}")
	public Cart fetchCartById(@PathVariable int cartId) {
		return cartservice.getAllCartByID(cartId);

	}

}
