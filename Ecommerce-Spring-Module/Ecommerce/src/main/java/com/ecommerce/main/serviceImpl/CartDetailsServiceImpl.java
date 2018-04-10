package com.ecommerce.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.dao.CartDetails;
import com.ecommerce.main.dao.ProductTable;
import com.ecommerce.main.repository.CartDetailsRepository;
import com.ecommerce.main.service.CartDetailsService;

@Service
public class CartDetailsServiceImpl implements CartDetailsService {

	
	CartDetails cart =new CartDetails();
	@Autowired
	private CartDetailsRepository cartDetailsRepository;

	public Optional<CartDetails> getCartDetails(int id) {
		return cartDetailsRepository.findById(id);
	}

	public String updateCartDetails(ProductTable product, long id) {
		if (product != null) {
			cart.setUserId(id);
			cart.setProductId(product);
			cart.setDeliveryAddress("hello");
			if (cartDetailsRepository.save(cart) != null)
				return "SucessFully Updated";
		}
		return "error";
	}

	public List<CartDetails> getAllCartDetails() {

		List<CartDetails> cartList = new ArrayList<>();
		cartDetailsRepository.findAll().forEach(cartList::add);

		return cartList;
	}

}
