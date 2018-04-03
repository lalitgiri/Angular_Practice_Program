package com.ecommerce.main.serverConfigurations;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;

public class JWTConfigurer extends SecurityConfigurerAdapter {

	public JWTConfigurer(TokenProvider tokenProvider) {
		
	}

}
