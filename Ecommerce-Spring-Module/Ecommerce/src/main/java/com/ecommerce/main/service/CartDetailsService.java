package com.ecommerce.main.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.main.dao.CartDetails;
import com.ecommerce.main.dao.ProductTable;


public interface CartDetailsService {
	

	public Optional<CartDetails> getCartDetails(int id);
	
	public String updateCartDetails(ProductTable product,long id) ;
	
	public List<CartDetails> getAllCartDetails();
	
}
