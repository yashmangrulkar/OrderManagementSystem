package com.oms.cart.cartservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oms.cart.cartservice.model.Cart;
import com.oms.cart.cartservice.model.Products;
import com.oms.cart.cartservice.model.User;
import com.oms.cart.cartservice.repository.CartRepository;

@Service
public class CartServiceImpl implements Cartservice {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

	@Autowired
	CartRepository cartRepository;

//  Fetching all the Data from Products Service	
	@Override
	public Products[] getAllProducts() {

		RestTemplate restTemplate = new RestTemplate();

		Products[] productsList = restTemplate.getForObject("http://localhost:8082/allproducts", Products[].class);
		return productsList;

	}

// Add the Products into the Cart	
	@Override
	public void addToCart(String username, String password, int cartId) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("username", username);
		uriVariables.put("password", password);

		ResponseEntity<User> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8081/login/{username}/{password}", User.class, uriVariables);

		User response = responseEntity.getBody();

		Products[] productList = getAllProducts();
		List<Products> products = Arrays.asList(productList);

		System.out.println("The User Response is :" + response.toString());

		if (response != null) {

			Cart cart = new Cart();
			cart.setCartId(cartId);
			cart.setUsername(username);
			cart.setPassword(password);
			cart.setUserId(response.getUserId());

			if (products != null) {
				List<Products> prodList = new ArrayList<>();
				prodList.add(products.get(6));
				prodList.add(products.get(7));
				prodList.add(products.get(8));

				cart.setProducts(prodList);
			}
			cartRepository.save(cart);
		} else {
			LOGGER.info("Username or Password is Incorrect");
		}
	}

	@Override
	public Cart removeProductFromCart(int cartId, int productID) {

		//Optional<Cart> cartOptional = cartRepository.findById(cartId);
		Cart cart = getAllCartByID(cartId);
		if (cart != null) {
			for (Products product : cart.getProducts()) {
				if (product.getProductID() == productID) {
					cart.getProducts().remove(product);
				}
			}
		}

		cartRepository.save(cart);

		return cart;

	}
	
	public Cart getAllCartByID(int cartId) {
	 return cartRepository.findById(cartId).get();
		
	}

}
