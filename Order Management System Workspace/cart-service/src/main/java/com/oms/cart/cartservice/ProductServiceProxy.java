package com.oms.cart.cartservice;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.oms.cart.cartservice.model.Products;

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name ="product-service")
public interface ProductServiceProxy {

	@GetMapping("/product-service/allproducts")
	public List<Products> fetchAllProduct();
}
