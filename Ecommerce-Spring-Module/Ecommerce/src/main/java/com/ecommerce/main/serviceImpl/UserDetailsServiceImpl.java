package com.ecommerce.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.dao.UserDetails;
import com.ecommerce.main.repository.UserDetailsRepository;
import com.ecommerce.main.service.UserDetailsService;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	
	public String addUserDetails(UserDetails user) throws Exception {
		userDetailsRepository.save(user);
		return "Sucessfully Added";
	}
	
	
	public String deleteUserDetails(long id){
		if(userDetailsRepository.existsById(id)) {
			userDetailsRepository.deleteById(id);
			return "SucessFully Deleted";
		}
		return "Illegal Operation";
	}
	
	public Optional<UserDetails> getUserDetails(long id) {
		return userDetailsRepository.findById(id);
		
	}
	
	public String updateUserDetails(UserDetails user,long id) {
		if(userDetailsRepository.existsById(id)) {
		userDetailsRepository.save(user);
		return "SucessFully Updated";
		}
		return "Illegal Operation";
	}
	
	public List<UserDetails> getAllUserDetails(){
		
		List <UserDetails> userList = new ArrayList<>();
		userDetailsRepository.findAll().
		forEach(userList::add);
					
		if(userList== null) 
			return  null;
		return userList;
	}


	
	public String userAuthentication(String emailId,String password) {
		
		UserDetails user=userDetailsRepository.findByemailIdAndPassword(emailId,password);
		System.out.println(user+"  "+emailId+"  "+ password);
		if(user!=null)
		return "Sucessfully Login";
		
		return "Invalid Credentials";
	}
	
}
