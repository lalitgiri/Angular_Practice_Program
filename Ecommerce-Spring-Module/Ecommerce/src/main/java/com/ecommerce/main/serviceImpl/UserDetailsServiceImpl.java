package com.ecommerce.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.dao.UserDetails;
import com.ecommerce.main.reposiotory.UserDetailsReposiotory;
import com.ecommerce.main.service.UserDetailsService;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsReposiotory userDetailsReposiotory;
	
	
	public String addUserDetails(UserDetails user) throws Exception {
		userDetailsReposiotory.save(user);
		return "Sucessfully Added";
	}
	
	
	public String deleteUserDetails(long id){
		if(userDetailsReposiotory.existsById(id)) {
			userDetailsReposiotory.deleteById(id);
			return "SucessFully Deleted";
		}
		return "Illegal Operation";
	}
	
	public Optional<UserDetails> getUserDetails(long id) {
		return userDetailsReposiotory.findById(id);
		
	}
	
	public String updateUserDetails(UserDetails user,long id) {
		if(userDetailsReposiotory.existsById(id)) {
		userDetailsReposiotory.save(user);
		return "SucessFully Updated";
		}
		return "Illegal Operation";
	}
	
	public List<UserDetails> getAllUserDetails(){
		
		List <UserDetails> userList = new ArrayList<>();
		userDetailsReposiotory.findAll().
		forEach(userList::add);
				
		
		if(userList== null) 
			return  null;
		return userList;
	}
	
}
