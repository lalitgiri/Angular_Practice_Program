package com.example.springbootJWT.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.example.springbootJWT.Model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{

	public JwtAuthenticationTokenFilter() {
		//super("/rest/**");
		super("rest/**");
		
	}

	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest arg0, HttpServletResponse arg1)
			throws AuthenticationException, IOException, ServletException {
		
		System.out.println("Hello");
		String header=arg0.getHeader("Authorization");
		if(header==null ||!header.startsWith("Token ")) {
			throw new RuntimeException("Jwt Token Is Missing");
		}
		
		String authenticationToken = header.substring(6);
		
		//return new JwtAuthenticationToken(authenticationToken);

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
