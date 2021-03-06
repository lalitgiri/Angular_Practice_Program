package com.example.springbootJWT.Security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.springbootJWT.Model.JwtAuthenticationToken;
import com.example.springbootJWT.Model.JwtUser;
import com.example.springbootJWT.Model.JwtUserDetails;

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
	protected UserDetails retrieveUser(String arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		
	JwtAuthenticationToken jwtAuthenticationToken=(JwtAuthenticationToken)arg1;
	String token=jwtAuthenticationToken.getToken();
	JwtUser jwtUser=validator.validate(token);
	if(jwtUser==null) {
		throw new RuntimeException("JWT TOKEN IS INCORRECT");
	}
	List<GrantedAuthority> grantedAuthorities = AuthorityUtils
			.commaSeparatedStringToAuthorityList(jwtUser.getRole());

	return new JwtUserDetails(jwtUser.getUserName(), token, jwtUser.getId(), grantedAuthorities);
	}
	
	
}
