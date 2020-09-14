package com.oms.order.orderservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderProduct {
	@Id
	private int orderProductId;
	public int getOrderProductId() {
		return orderProductId;
	}
	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	private String orderStatus;
	

}
