package com.example.demo.rest.security.auth_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.rest.common.security.core.Constants;

/**
 * Spring Boot Launcher
 * 
 * @author Igor Peonte <igor.144@gmail.com>
 *
 */
@SpringBootApplication
public class AuthServerWebApp {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerWebApp.class, args);
	}

	/**
	 * Inject user name was used during login into standard http session
	 * 
	 * @param event
	 */
	@EventListener
	public void handleAuthenticationSuccessEvent(AuthenticationSuccessEvent event) {
		(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession(false))
				.setAttribute(Constants.USER_NAME_KEY,
						((UsernamePasswordAuthenticationToken) event.getSource()).getName());

	}


}
