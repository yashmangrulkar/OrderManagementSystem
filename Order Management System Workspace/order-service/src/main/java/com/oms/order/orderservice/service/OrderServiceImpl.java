package com.oms.order.orderservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.oms.order.orderservice.model.Cart;
import com.oms.order.orderservice.model.Order;
import com.oms.order.orderservice.model.Products;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Products> getAllProducts(int cartId) {
		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("cartId", cartId);

		ResponseEntity<Cart> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8084/fetchCart/{cartId}", Cart.class, uriVariables);
		Cart cart = responseEntity.getBody();
		return cart.getProducts();

	}

	@Override
	public void placedOrder(int cartId, int productId) {
		List<Products> productList = getAllProducts(cartId);
		if (productList != null) {
			Order order = new Order();
			order.setDate(LocalDate.now());

		}

	}

	

}
