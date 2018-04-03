package com.example.springbootJWT.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.example.springbootJWT.Model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{

	public JwtAuthenticationTokenFilter() {
		//super("/rest/**");
		super("/rest/hello");
		
	}

	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest arg0, HttpServletResponse arg1)
			throws AuthenticationException, IOException, ServletException {
		
		System.out.println("Hello");
		String header=arg0.getHeader("Authorization");
		if(header==null ||!header.startsWith("Token")) {
			throw new RuntimeException("Jwt Token Is Missing");
		}
		
		String authenticationToken = header.substring(6);
		
		return new JwtAuthenticationToken(authenticationToken);
		
		
	}


	public void setAuthenticationSucessHandler(JwtSucessHandler jwtSucessHandler) {
		
	
	}

}
