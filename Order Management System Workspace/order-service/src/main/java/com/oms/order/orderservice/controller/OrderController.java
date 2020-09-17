package com.oms.order.orderservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oms.order.orderservice.model.Cart;
import com.oms.order.orderservice.service.OrderService;

@RestController
public class OrderController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderService orderService;

	@GetMapping("/placeorder/{username}/{password}/{cartId}/{productID}/{orderId}")
	public Cart placeOrder(@PathVariable String username, @PathVariable String password, @PathVariable int cartId,
			@PathVariable int productID, @PathVariable int orderId) {

		logger.info("{}", "In Place Order Method");
		return orderService.placedOrder(username, password, cartId, productID, orderId);

	}

	@GetMapping("/placeorderfeign/{username}/{password}/{cartId}/{productID}/{orderId}")
	public Cart placeOrderFeign(@PathVariable String username, @PathVariable String password, @PathVariable int cartId,
			@PathVariable int productID, @PathVariable int orderId) {

		logger.info("{}", "In Place Order Feign Method");

		return orderService.placedOrderFeign(username, password, cartId, productID, orderId);

	}

}
