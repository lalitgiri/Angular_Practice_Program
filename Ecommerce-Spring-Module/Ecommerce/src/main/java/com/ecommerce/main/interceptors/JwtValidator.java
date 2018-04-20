package com.ecommerce.main.interceptors;


import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

private final String secret="lalit";

	public User validate(String token) {
		User user=null;
		try {
		Claims body=Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		user=new User();
		/*user.setEmailAddress(body.getSubject());
		user.setId(((String )body.get("UserId")));
		user.setRole((String)body.get("role")) ;*/
		
		user.setEmailAddress(body.getSubject());
		user.setId(((String )body.get("UserId")));
		user.setRole((String)body.get("role")) ;
		user.setPhoneNumber((long)body.get("phoneNumber"));
		user.setUserId((long)body.get("userId"));
		user.setUserName((String)body.get("userName"));
		}
		catch(Exception e) {System.out.println(e);}
		return user;
	}

}
