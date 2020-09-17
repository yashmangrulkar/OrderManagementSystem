package com.oms.product.productservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.product.productservice.model.Products;
import com.oms.product.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Products> getProductList() {
		LOGGER.info("Start getProductList method");
		List<Products> productList = null;
		try {
			productList = productRepository.findAll();
		} catch (Exception e) {
			LOGGER.error("Error occured while fetching getProductList method: " + e.getMessage());
		}
		LOGGER.info("Start getProductList method");
		LOGGER.info("{}", productList);
		return productList;
	}

	@Override
	public Optional<Products> getProductById(int productID) {

		return productRepository.findById(productID);
	}

}
