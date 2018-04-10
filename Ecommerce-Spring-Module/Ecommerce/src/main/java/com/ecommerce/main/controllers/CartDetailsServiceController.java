package com.ecommerce.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dao.CartDetails;
import com.ecommerce.main.service.CartDetailsService;

@RestController
public class CartDetailsServiceController {

	@Autowired
	private CartDetailsService cartDetailsService;
	
	@RequestMapping("/getcart/{id}")
	public Optional<CartDetails> getCartDetails(@PathVariable int id){
		return cartDetailsService.getCartDetails(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/updatecart/{id}/{pid}")
	public String updateCartDetails(@PathVariable long id,@PathVariable int pid) {
	 String str=cartDetailsService.updateCartDetails(pid, id);
	 System.out.println(str);
	 return str;
	}
	
	@RequestMapping("/getallcartsdetails")
	public List<CartDetails> getAllCartDetails(){
		return cartDetailsService.getAllCartDetails();
	}
}
