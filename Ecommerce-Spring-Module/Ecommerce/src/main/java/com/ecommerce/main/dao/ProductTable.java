package com.ecommerce.main.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ProductTable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int productId;    		//primaryKey
	private String productName;
	private String productCategory;
	private long productQuantity;
	private long productPrice;
	private String description;
	private String imageUrl;
	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	private EmployeeDetails employeeId; 			//foreginKey
	
	@ManyToMany
	private List<CartDetails> cartId;
	
	public List<CartDetails> getCartId() {
		return cartId;
	}
	public void setCartId(List<CartDetails> cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public long getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public EmployeeDetails getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(EmployeeDetails employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
}
