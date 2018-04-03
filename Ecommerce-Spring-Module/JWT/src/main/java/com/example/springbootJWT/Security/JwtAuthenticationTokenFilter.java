package com.example.springbootJWT.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.example.springbootJWT.Model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{

	public JwtAuthenticationTokenFilter() {
		super("/**/rest");
		
	}

	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest arg0, HttpServletResponse arg1)
			throws AuthenticationException, IOException, ServletException {
		
		
		String header=arg0.getHeader("Authorisation");
		if(header==null ||!header.startsWith("Token")) {
			throw new RuntimeException("Jwt Token Is Missing");
		}
		
		String authenticationToken = header.substring(6);
		
		return new JwtAuthenticationToken(authenticationToken);
		
		
	}


	public void setAuthenticationSucessHandler(JwtSucessHandler jwtSucessHandler) {
		
		
	}

}
