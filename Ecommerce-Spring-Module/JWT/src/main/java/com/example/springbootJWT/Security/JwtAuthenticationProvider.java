package com.example.springbootJWT.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.springbootJWT.Model.JwtAuthenticationToken;
import com.example.springbootJWT.Model.JwtUser;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtValidator validator;
	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		System.out.println("retrieveUser1");
		
	}

	@Override
	protected UserDetails retrieveUser(String arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		System.out.println("retrieveUser");
	JwtAuthenticationToken jwtAuthenticationToken=(JwtAuthenticationToken)arg1;
	String token=jwtAuthenticationToken.getToken();
	JwtUser jwtUser=validator.validate(token);
	if(jwtUser==null) {
		throw new RuntimeException("JWT TOKEN IS INCORRECT");
	}
		return null;
	}
	
	
}
