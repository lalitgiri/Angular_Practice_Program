package com.ecommerce.main.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.dao.UserDetails;
import com.ecommerce.main.service.UserDetailsService;

@RestController
public class SessionController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/getAuthentication")
	public String handleLoginRequest( HttpServletRequest request, HttpServletResponse response,
			@RequestBody Map<String, String> userRequest) {
		
		User user=new User();
		String emailId = userRequest.get("Username");
		String password = userRequest.get("lpassword");
	
				
		UserDetails userDetails=userDetailsService.userAuthentication(emailId, password);
		{
			System.out.println("Name= "+userDetails.getName()+"  Id: "+userDetails.getCart().getUserId());
			
		}
		
		if (userDetails!=null) {
			
			user.setEmailAddress(userRequest.get("Username"));
			user.setId(userRequest.get("lpassword"));
			user.setUserName(userDetails.getName());
			user.setUserId(userDetails.getCart().getUserId());
			user.setRole("User");
			
			
			User loggedUser = userService.loginUser(user);
			if (loggedUser == null) {
				userService.addUser(user);
				request.getSession(true).setAttribute("user", user);				
				TokenProvider tokenProvider =new TokenProvider();
						
				String token = tokenProvider.generate(user);
				
				//response.addHeader("token",token);
				
				System.out.println(token);
				return token;
			}
		}
		return null;
	}

	
	@RequestMapping("/logout")
	public boolean removeSession(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
		
		 JwtValidator validate= new JwtValidator();
		 
		 User user=validate.validate(request.getHeader("token"));
		 User loggedUser = userService.loginUser(user);
			if (loggedUser != null) {
				if(userService.removeUser(user)) {
				request.getSession(true).removeAttribute("user");				
				System.out.println("Sucessfully Deleted");
				return true;
				}
			}
		return false;
	 }
}
