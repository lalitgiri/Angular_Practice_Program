package com.ecommerce.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.dao.CartDetails;
import com.ecommerce.main.dao.ProductTable;
import com.ecommerce.main.repository.CartDetailsRepository;
import com.ecommerce.main.repository.ProductTableRepository;
import com.ecommerce.main.service.CartDetailsService;

@Service
public class CartDetailsServiceImpl implements CartDetailsService {

	@Autowired
	private CartDetailsRepository cartDetailsRepository;
	
	@Autowired
	private ProductTableRepository productTableRepository;
	
	public Optional<CartDetails> getCartDetails(int id) {
		return cartDetailsRepository.findById(id);
	}
	
	public String updateCartDetails(int pid,long id) {
		//CartDetails cart=new CartDetails();
	//	ProductTable product= productTableRepository.findById(id);
		
		
		//cart.setUserId(id);
		//cartDetailsRepository.save(cart);
		return "SucessFully Updated";
	}
	
	public List<CartDetails> getAllCartDetails(){
		
		List <CartDetails> cartList = new ArrayList<>();
		cartDetailsRepository.findAll().
		forEach(cartList::add);
		
		return cartList;
	}
	
	
	
}
