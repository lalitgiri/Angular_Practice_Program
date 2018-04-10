
package com.ecommerce.main.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CartDetails {
	
	@Id
	@Column(name = "UserID")
	private long userId;		//primaryKey
	@ManyToMany(mappedBy="cartId")
	private List<ProductTable> productId;	//foreginKey
	
	private String deliveryAddress;
	
	

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
	public void setProductId(ProductTable product) {
		this.productId.add(product);
	}
	
}
