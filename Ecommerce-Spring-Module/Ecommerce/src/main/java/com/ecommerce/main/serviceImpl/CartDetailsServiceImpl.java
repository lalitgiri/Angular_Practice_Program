package com.ecommerce.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.dao.CartDetails;
import com.ecommerce.main.reposiotory.CartDetailsReposiotory;
import com.ecommerce.main.service.CartDetailsService;

@Service
public class CartDetailsServiceImpl implements CartDetailsService {

	@Autowired
	private CartDetailsReposiotory cartDetailsReposiotory;
	
	
	
	public Optional<CartDetails> getCartDetails(int id) {
		
		return cartDetailsReposiotory.findById(id);
	}
	
	public String updateCartDetails(CartDetails cart,long id) {
		
		cartDetailsReposiotory.save(cart);
		return "SucessFully Updated";
	}
	
	public List<CartDetails> getAllCartDetails(){
		
		List <CartDetails> cartList = new ArrayList<>();
		cartDetailsReposiotory.findAll().
		forEach(cartList::add);
		
		return cartList;
	}
	
	
	
}
