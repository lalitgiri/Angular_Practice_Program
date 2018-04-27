package com.ecommerce.main.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.cartHandler.CartHandlerSupportClass;
import com.ecommerce.main.cartHandler.ProductQuantity;
import com.ecommerce.main.dao.CartDetails;
import com.ecommerce.main.dao.ProductTable;
import com.ecommerce.main.repository.CartDetailsRepository;
import com.ecommerce.main.service.CartDetailsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CartDetailsServiceImpl implements CartDetailsService {

	@Autowired
	private CartDetailsRepository cartDetailsRepository;

	CartDetails cart = new CartDetails();
	List<ProductTable> productList = new ArrayList<>();

	public String getCartDetails(int id) {
		String jsonResult = null;
		CartHandlerSupportClass cartHandlerSupportClass =new CartHandlerSupportClass();
		List<ProductQuantity> productQuantity = new ArrayList<ProductQuantity>();
	
		if (cartDetailsRepository.findById(id).get() != null) {

			CartDetails cartDetails = cartDetailsRepository.findById(id).get();
			
			List<ProductTable> list = cartDetails.getProductId();
			Set<ProductTable> uniqueProducts = new HashSet<>();
			list.forEach(p -> uniqueProducts.add(p));
			List<ProductTable> uniqueIds = uniqueProducts.stream().collect(Collectors.toList());
			//int count = 0;
			for(ProductTable i : uniqueIds) {
				int count = 0;
				 for (ProductTable p : list) {
					 if(p.equals(i)) {
						 count++;
					 }
					}
				 productQuantity.add(new ProductQuantity(count,i) );
				 
			}
			
			
			productQuantity.forEach(System.out::print);
				
			
		
			
			cartHandlerSupportClass.setProductQuantity(productQuantity);

			cartHandlerSupportClass.setDeliveryAddress(cartDetails.getDeliveryAddress());
			
			cartHandlerSupportClass.setUserId(cartDetails.getUserId());
			
			ObjectMapper mapper = new ObjectMapper();
			try {
				jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cartHandlerSupportClass);
				//jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonResult+"hello"+cartDetails.getUserId());
				
			} catch (JsonProcessingException e) {

				e.printStackTrace();
			}

		

			
			 // Set<Entry<ProductTable,Integer>> ssss = data.entrySet();
			 // ssss.forEach(System.out::println); return cartDetailsRepository.findById(id);
			 
			return jsonResult;

	}
		return "hello";
	}

	public String updateCartDetails(ProductTable product, int id) {

		if (product != null) {
			cart.setUserId(id);
			if (addItemToCart(product, id))
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

	public boolean addItemToCart(ProductTable product, int id) {
		productList = new ArrayList<>();
		Optional<CartDetails> cart2 = cartDetailsRepository.findById(id);
		if (cart2.isPresent()) {
			productList = cart2.get().getProductId();
			productList.add(product);
			return true;
		}

		return false;
	}

	public String removeItemFromCart(ProductTable product, int id) {

		Optional<CartDetails> cart2 = cartDetailsRepository.findById(id);
		if (cart2.isPresent()) {
			productList = cart2.get().getProductId();

			if (removeItemLocal(product)) {
				cart2.get().setProductId(productList);
				cartDetailsRepository.save(cart2.get());
				return "itemRemoved";
			}
			return "item not removed";

		}
		return "Item Not Avaliable In Cart";
	}

	public boolean removeItemLocal(ProductTable product) {

		System.out.println(productList.size());
		List<ProductTable> list = new ArrayList<>();
		productList.forEach(u -> {
			if (u.getProductId() != product.getProductId()) {
				list.add(u);
			}

		});
		if (list != null) {
			productList = list;
			// list.size();
			System.out.println(productList.size());
			return true;
		}
		return false;

	}
}
