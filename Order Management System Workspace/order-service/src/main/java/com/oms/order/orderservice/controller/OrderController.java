package com.oms.order.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oms.order.orderservice.model.Cart;
import com.oms.order.orderservice.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/placeorder/{username}/{password}/{cartId}/{productID}/{orderId}")
	public Cart placeOrder(@PathVariable String username,@PathVariable String password,@PathVariable int cartId, @PathVariable int productID, @PathVariable int orderId) {
		return orderService.placedOrder(username, password, cartId, productID, orderId);
		
	}

}
