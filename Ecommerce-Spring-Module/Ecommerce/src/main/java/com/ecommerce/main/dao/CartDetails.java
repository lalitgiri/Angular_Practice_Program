
package com.ecommerce.main.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CartDetails {
	
	@Id
	@Column(name = "UserID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userId;		//primaryKey
	@ManyToMany
	private List<ProductTable> productId;	//foreginKey
	
	private String deliveryAddress;
	
	

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

	
	public List<ProductTable> getProductId() {
		return productId;
	}
	public void setProductId(List<ProductTable> productId) {
		this.productId = productId;
	}
	
}
