package com.oms.order.orderservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderedProduct {

	@Id
	private int orPrID;
	private String orproductName;
	public int getOrPrID() {
		return orPrID;
	}
	public void setOrPrID(int orPrID) {
		this.orPrID = orPrID;
	}
	public String getOrproductName() {
		return orproductName;
	}
	public void setOrproductName(String orproductName) {
		this.orproductName = orproductName;
	}


}
