package com.oms.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.order.orderservice.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
