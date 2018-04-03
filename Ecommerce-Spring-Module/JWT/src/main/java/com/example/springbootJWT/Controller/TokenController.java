package com.example.springbootJWT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootJWT.Model.JwtUser;
import com.example.springbootJWT.Security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private JwtGenerator jwtGenerator;
	
	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator=jwtGenerator;
	}
	
	@PostMapping
	public String generate(@RequestBody final JwtUser jwtUser) {
		return jwtGenerator.generate(jwtUser);
	}
}
