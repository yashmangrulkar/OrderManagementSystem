package com.oms.product.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.product.productservice.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
