package com.example.springsecurityexample.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.example.springsecurityexample.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	public JwtAuthenticationTokenFilter() {
		super("rest/**");
	
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AuthenticationException, IOException, ServletException {
		
		String header=httpServletRequest.getHeader("Authorization");
		
		if(header==null || header.startsWith("Token ")) {
			throw new RuntimeException("Jwt Token Is Missing");
		}
		
		String authenticationToken=header.substring(6);
		
		JwtAuthenticationToken token=new JwtAuthenticationToken(authenticationToken);
		return getAuthenticationManager().authenticate(token);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}

}
