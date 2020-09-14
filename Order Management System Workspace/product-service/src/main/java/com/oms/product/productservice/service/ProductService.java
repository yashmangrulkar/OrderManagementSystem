package com.oms.product.productservice.service;

import java.util.List;
import java.util.Optional;

import com.oms.product.productservice.model.Products;

public interface ProductService {

	public List<Products> getProductList();
	
	public Optional<Products> getProductById(int productID);
	
	
}
