package com.ecommerce.main.cartHandler;

import java.util.List;

public class CartOrderHandlerSupportClass {
	
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
