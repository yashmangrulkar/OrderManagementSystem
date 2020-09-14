package com.oms.order.orderservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {

	@Id
	private int productID;
	private String productName;

	@Override
	public String toString() {
		return "Products [productID=" + productID + ", productName=" + productName + "]";
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
