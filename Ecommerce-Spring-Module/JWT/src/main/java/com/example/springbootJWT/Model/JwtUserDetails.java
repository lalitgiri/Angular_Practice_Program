package com.example.springbootJWT.Model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String token;
	private long id;
	private Collection<? extends GrantedAuthority> authority;

	public JwtUserDetails(String userName, String token, long id, Collection<? extends GrantedAuthority> authority) {
		super();
		this.userName = userName;
		this.token = token;
		this.id = id;
		this.authority = authority;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		
		return true;
	}

	public String getUserName() {
		return userName;
	}
	public String Token() {
		return token;
	}
	
	public long  getId() {
		return id;
	}
}
