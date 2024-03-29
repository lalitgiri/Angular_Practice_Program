package com.example.springsecurityexample.security;

import org.springframework.stereotype.Component;

import com.example.springsecurityexample.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
	
	private final String secret="Lalit";
	public JwtUser validate(String token) {
		JwtUser jwtUser=null;
		try {
		Claims body=Jwts.parser()
							.setSigningKey(secret)
							.parseClaimsJws(token)
							.getBody();
		
		jwtUser=new JwtUser();
		jwtUser.setUserName(body.getSubject());
		jwtUser.setId(Long.parseLong((String)body.get("userId")));
		jwtUser.setRole((String)body.get("role"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return jwtUser;
	}

}
