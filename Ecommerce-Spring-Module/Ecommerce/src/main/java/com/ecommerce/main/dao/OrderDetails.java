package com.ecommerce.main.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {

	@Id
	private int orderId;  //primaryKey
	
	private String  address;
	private ProductTable itemDetail;
	
	private boolean status;
	@ManyToOne
	private UserDetails userId;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public UserDetails getUserId() {
		return userId;
	}
	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ProductTable getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(ProductTable itemDetail) {
		this.itemDetail = itemDetail;
	}
	
	
}
