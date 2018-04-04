/*package com.ecommerce.main.serverConfigurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MultiHttpSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Configuration
    @Order(1)
    public class ApiSecurityAdapter extends WebSecurityConfigurerAdapter {

        private TokenProvider tokenProvider;

        public ApiSecurityAdapter(TokenProvider tokenProvider) {
            this.tokenProvider = tokenProvider;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            ((HttpSecurity) http.antMatcher("/api/**") //<= Security only available for /api/**
                .authorizeRequests()
                    .antMatchers("/api/register").permitAll()
                    .antMatchers("/api/login").permitAll()
                    .antMatchers("/api/public").permitAll()
                    .antMatchers("/api/lost").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .apply(new JWTConfigurer(this.tokenProvider))
                .and())
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }
    }
}*/