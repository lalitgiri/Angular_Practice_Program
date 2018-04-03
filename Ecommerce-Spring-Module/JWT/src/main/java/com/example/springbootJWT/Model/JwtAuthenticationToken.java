package com.example.springbootJWT.Model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;
	 public JwtAuthenticationToken(String token) {
		super(null,null);
		System.out.println("JwtAuthenticationToken");
		this.token=token;
		System.out.println("JwtAuthenticationToken1");
		
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public Object getCreditials() {
		return null;
	}
	
	public Object getPrincipal() {
		return null;
	}

}
