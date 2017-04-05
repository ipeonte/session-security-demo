package com.example.demo.rest.security.client.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * /info Controller
 * 
 * @author Igor Peonte <igor.144@gmail.com>
 *
 */
@RestController
@RequestMapping("/info")
public class InfoController {
	
	/**
	 * Display all session attributes.
	 * 
	 * @param req
	 * @return String with all session attributes
	 */
	@RequestMapping
	public String showLoginInfo(HttpServletRequest req) {
		// Dump all session parameters
		String message = "";
		HttpSession session = req.getSession(false);
		
		if (session != null) {
			message += "Session Id - " + session.getId() + "<hr />";
			Enumeration<String> attrs = session.getAttributeNames();
			
			while (attrs.hasMoreElements()) {
				String key = attrs.nextElement();
				message += key + "=" + session.getAttribute(key) + "<br />";
			}
			
			message += "<hr />";
		}
		
		return message;
	}

}
