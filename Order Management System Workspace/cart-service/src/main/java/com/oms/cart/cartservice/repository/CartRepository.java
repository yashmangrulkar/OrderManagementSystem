package com.oms.cart.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.cart.cartservice.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {


}
