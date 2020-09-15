package com.oms.order.orderservice.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	private int orderId;
	private LocalDate date;
	private String orderStatus;

	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderedProduct> orderedProductList;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderedProduct> getOrderedProductList() {
		return orderedProductList;
	}

	public void setOrderedProductList(List<OrderedProduct> orderedProductList) {
		this.orderedProductList = orderedProductList;
	}

}
