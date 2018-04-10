package com.ecommerce.main.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dao.UserDetails;
import com.ecommerce.main.interceptors.TokenProvider;
import com.ecommerce.main.interceptors.User;
import com.ecommerce.main.interceptors.UserService;
import com.ecommerce.main.service.UserDetailsService;

@RestController
public class UserDetailsServiceController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/adduser")
	public String addUserDetails(@RequestBody UserDetails newUser,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String message= userDetailsService.addUserDetails(newUser);
		
		if(message.equals("Sucessfully Added")) {
		User user=new User();
		
		String emailId = newUser.getEmailId();
		String password = newUser.getPassword();
	
		user.setRole("User");
		user.setEmailAddress(emailId);
		user.setId(password);
		userService.addUser(user);
		request.getSession(true).setAttribute("user", user);				
		TokenProvider tokenProvider =new TokenProvider();
		User userToken = new User();
		userToken.setEmailAddress(emailId);
		userToken.setId(password);
		userToken.setRole("User");

		String token = tokenProvider.generate(userToken);
		
		return token;
		}
		return message;
	}

	@RequestMapping("/deleteuser/{id}")
	public String deleteUserDetails(@PathVariable long id) {
		return userDetailsService.deleteUserDetails(id);
	}

	@RequestMapping("/getuser/{id}")
	public Optional<UserDetails> getUserDetails(@PathVariable long id) {
		return userDetailsService.getUserDetails(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateuser/{id}")
	public String updateUserDetails(@RequestBody UserDetails user, @PathVariable long id) {
		return userDetailsService.updateUserDetails(user, id);
	}

	@RequestMapping("/getalluser")
	public List<UserDetails> getAllUserDetails() {
		return userDetailsService.getAllUserDetails();
	}

	/*
	 * @RequestMapping(method = RequestMethod.POST, value = "/getAuthentication")
	 * public String userAuthentication(@RequestBody Map<String, String> user) {
	 * 
	 * String emailId = user.get("Username"); String password =
	 * user.get("lpassword"); return userDetailsService.userAuthentication(emailId,
	 * password);
	 * 
	 * }
	 */
	
}
