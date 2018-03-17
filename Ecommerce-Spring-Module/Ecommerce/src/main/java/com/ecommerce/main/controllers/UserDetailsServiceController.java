package com.ecommerce.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dao.UserDetails;
import com.ecommerce.main.service.UserDetailsService;

@RestController
public class UserDetailsServiceController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(method=RequestMethod.POST,value="/adduser")
	public String addUserDetails(@RequestBody UserDetails user) throws Exception {
		return userDetailsService.addUserDetails(user);
	}
	
	@RequestMapping("/deleteuser/{id}")
	public String deleteUserDetails(@PathVariable long id){
		return userDetailsService.deleteUserDetails(id);
	}
	
	@RequestMapping("/getuser/{id}")
	public Optional<UserDetails> getUserDetails(@PathVariable long id) {
		return userDetailsService.getUserDetails(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/updateuser/{id}")
	public String updateUserDetails(@RequestBody UserDetails user, @PathVariable long id) {
		return userDetailsService.updateUserDetails(user, id);
	}
	
	@RequestMapping("/getalluser")
	public List<UserDetails> getAllUserDetails(){
		return userDetailsService.getAllUserDetails();
	}
	
	
}
