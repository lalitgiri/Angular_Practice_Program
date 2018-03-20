package com.ecommerce.main.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.main.dao.CartDetails;


public interface CartDetailsService {
	

	public Optional<CartDetails> getCartDetails(int id);
	
	public String updateCartDetails(CartDetails cart,long id) ;
	
	public List<CartDetails> getAllCartDetails();
	
}
