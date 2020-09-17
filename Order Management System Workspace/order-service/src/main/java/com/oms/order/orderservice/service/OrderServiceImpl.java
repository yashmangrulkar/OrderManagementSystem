package com.oms.order.orderservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oms.order.orderservice.CartServiceProxy;
import com.oms.order.orderservice.model.Cart;
import com.oms.order.orderservice.model.OrderedProduct;
import com.oms.order.orderservice.model.Orders;
import com.oms.order.orderservice.model.Products;
import com.oms.order.orderservice.model.User;
import com.oms.order.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CartServiceProxy proxy;

	// Get AllProducts by CartId
	@Override
	public List<Products> getAllProducts(int cartId) {

		Cart cart = proxy.fetchCartById(cartId);
		return cart.getProducts();

	}

	// Place Order

	@Override
	public Cart placedOrder(String username, String password, int cartId, int productId, int orderId) {
		Cart cart = null;
		try {

			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("username", username);
			uriVariables.put("password", password);

			ResponseEntity<User> responseEntity = new RestTemplate()
					.getForEntity("http://localhost:8081/login/{username}/{password}", User.class, uriVariables);

			User response = responseEntity.getBody();

			if (response != null) {
				List<OrderedProduct> orderProductList = new ArrayList<>();
				List<Products> productList = getAllProducts(cartId);
				if (productList != null) {
					Orders order = new Orders();
					order.setDate(LocalDate.now());
					order.setOrderId(orderId);
					order.setOrderStatus("Ordered");

					for (Products product : productList) {
						if (product.getProductID() == productId) {
							OrderedProduct orderProduct = new OrderedProduct();
							orderProduct.setOrPrID(product.getProductID());
							orderProduct.setOrproductName(product.getProductName());
							orderProductList.add(orderProduct);
						}
					}
					order.setOrderedProductList(orderProductList);
					orderRepository.save(order);
					cart = removeAfterPlacingOrder(productId, cartId);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("error while placing Order: " + e.getMessage());
		}

		LOGGER.info("{}", cart);
		return cart;
	}

	// Place Order via Feign

	@Override
	public Cart placedOrderFeign(String username, String password, int cartId, int productId, int orderId) {
		Cart cart = null;
		try {

			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("username", username);
			uriVariables.put("password", password);

			ResponseEntity<User> responseEntity = new RestTemplate()
					.getForEntity("http://localhost:8081/login/{username}/{password}", User.class, uriVariables);

			User response = responseEntity.getBody();

			if (response != null) {
				List<OrderedProduct> orderProductList = new ArrayList<>();
				List<Products> productList = getAllProducts(cartId);
				if (productList != null) {
					Orders order = new Orders();
					order.setDate(LocalDate.now());
					order.setOrderId(orderId);
					order.setOrderStatus("Ordered");

					for (Products product : productList) {
						if (product.getProductID() == productId) {
							OrderedProduct orderProduct = new OrderedProduct();
							orderProduct.setOrPrID(product.getProductID());
							orderProduct.setOrproductName(product.getProductName());
							orderProductList.add(orderProduct);
						}
					}
					order.setOrderedProductList(orderProductList);
					orderRepository.save(order);
					cart = removeAfterPlacingOrder(productId, cartId);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("error while placing Order: " + e.getMessage());
		}

		LOGGER.info("{}", cart);
		return cart;
	}

	public Cart removeAfterPlacingOrder(int productId, int cardId) {
		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("cartId", cardId);
		uriVariables.put("productID", productId);

		ResponseEntity<Cart> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8084/removefromcart/{cartId}/{productID}", Cart.class, uriVariables);
		Cart cart = responseEntity.getBody();
		return cart;
	}
}
