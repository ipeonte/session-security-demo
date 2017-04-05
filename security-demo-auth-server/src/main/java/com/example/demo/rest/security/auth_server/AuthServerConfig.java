package com.example.demo.rest.security.auth_server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security Configuration
 * 
 * @author Igor Peonte <igor.144@gmail.com>
 *
 */
@Configuration
public class AuthServerConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Define few users & roles
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
			.and().withUser("test").password("password").roles("TEST")
			.and().withUser("admin").password("password").roles("ADMIN");
	}

}
