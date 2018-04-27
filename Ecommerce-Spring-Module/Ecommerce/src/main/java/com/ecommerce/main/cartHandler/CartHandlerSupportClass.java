package com.ecommerce.main.cartHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecommerce.main.dao.ProductTable;

public class CartHandlerSupportClass {
	
	private int userId;
	private String deliveryAddress;
	
	private List<ProductQuantity> productQuantity;
	
	public List<ProductQuantity> getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(List<ProductQuantity> productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	

}
