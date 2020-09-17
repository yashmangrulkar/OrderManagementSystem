package com.oms.order.orderservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oms.order.orderservice.model.Cart;

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "cart-service")
public interface CartServiceProxy {

	@GetMapping("/cart-service/fetchCart/{cartId}")
	public Cart fetchCartById(@PathVariable int cartId);
}
