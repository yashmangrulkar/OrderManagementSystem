package com.oms.order.orderservice.service;

import java.util.List;

import com.oms.order.orderservice.model.Products;

public interface OrderService {
	public void placedOrder(int cartId,int productId);
	public List<Products> getAllProducts(int cartId);
	
}
