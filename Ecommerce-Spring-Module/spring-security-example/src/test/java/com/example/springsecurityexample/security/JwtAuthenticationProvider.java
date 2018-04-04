package com.example.springsecurityexample.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.springsecurityexample.model.JwtAuthenticationToken;
import com.example.springsecurityexample.model.JwtUser;
import com.example.springsecurityexample.model.JwtUserDetails;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtValidator validator;
	
	@Override
	public boolean supports(Class<?> aClass) {
		
		return JwtAuthenticationToken.class.isAssignableFrom(aClass);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		
		
	}

	@Override
	protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
			throws AuthenticationException {
		JwtAuthenticationToken jwtAuthenticationToken=(JwtAuthenticationToken) usernamePasswordAuthenticationToken;
		
		String token=jwtAuthenticationToken.getToken();
	
		JwtUser jwtUser=validator.validate(token);
		
		if(jwtUser==null) {
			throw new RuntimeException("JWT Token Is Incorrect");
		}
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
													.commaSeparatedStringToAuthorityList(jwtUser.getRole());
		
		return new JwtUserDetails(jwtUser.getUserName(),jwtUser.getId(),token,grantedAuthorities);
		
		
	}

}
