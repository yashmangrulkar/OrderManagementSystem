package com.oms.order.orderservice.service;

import java.util.List;

import com.oms.order.orderservice.model.Cart;
import com.oms.order.orderservice.model.Products;

public interface OrderService {
	public Cart placedOrder(String username, String password, int cartId, int productId, int orderId);

	public List<Products> getAllProducts(int cartId);

	public Cart removeAfterPlacingOrder(int productId, int cardId);

}
