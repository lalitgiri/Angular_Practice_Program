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
	
	@Autowired
	private CartDetailsRepository cartDetailsRepository;

	CartDetails cart =new CartDetails();
	List <ProductTable> productList= new ArrayList<>();
	
	public Optional<CartDetails> getCartDetails(int id) {
		return cartDetailsRepository.findById(id);
	}

	public String updateCartDetails(ProductTable product, int id) {
		
		if (product != null) {
			cart.setUserId(id);
			if(addItemToCart(product,id))
				cart.setProductId(productList);
			cart.setDeliveryAddress(null);
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
	public boolean addItemToCart(ProductTable product,int id) {
		productList=new ArrayList<>();
		Optional<CartDetails> cart2=cartDetailsRepository.findById(id);
		if(cart2.isPresent()) {
			productList=cart2.get().getProductId();
			productList.add(product);
			return true;
		}
		
		return false;
	}
	public String removeItemFromCart(ProductTable product,int id) {
		
		Optional<CartDetails> cart2 = cartDetailsRepository.findById(id);
		if(cart2.isPresent()) {
			productList=cart2.get().getProductId();
			
			if(removeItemLocal(product)) {
				cart2.get().setProductId(productList);
				cartDetailsRepository.save(cart2.get());
				return "itemRemoved";
			}
			return "item not removed";
			
		}
		return "Item Not Avaliable In Cart";
	}

	public boolean removeItemLocal(ProductTable product ) {
			
		System.out.println(productList.size());
		List<ProductTable> list = new ArrayList<>();
		productList.forEach(u ->{
			if(u.getProductId()!=product.getProductId()) {
				list.add(u);
			}
				
		});
		if(list!=null) {
			productList =list;
			//list.size();
		System.out.println(productList.size());
		return true;
		}
		return false;
		
	}
}
