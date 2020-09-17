package com.oms.product.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oms.product.productservice.model.Products;
import com.oms.product.productservice.service.ProductService;

@RestController
public class ProductController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;

	@GetMapping("/allproducts")
	public List<Products> fetchAllProduct() {
		List<Products> productList = productService.getProductList();

		logger.info("{}", productList);

		return productList;

	}

	@GetMapping("/getproduct/{productID}")
	public Optional<Products> fetchProductById(@PathVariable int productID) {

		return productService.getProductById(productID);
	}

}
