package com.ecommerce.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dao.CartDetails;
import com.ecommerce.main.serviceImpl.CartDetailsServiceImpl;


public interface CartDetailsService {
	

	public Optional<CartDetails> getCartDetails(int id);
	
	public String updateCartDetails(CartDetails cart,long id) ;
	
	public List<CartDetails> getAllCartDetails();
	
}
