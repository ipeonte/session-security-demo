package com.example.demo.rest.security.client.controller;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class to manage internal session parameter(s). Used to emulate security layer
 * which might inject certain security parameters during login
 * 
 * @author Igor Peonte <igor.144@gmail.com>
 *
 */
@RestController
@RequestMapping("/sessions")
@CrossOrigin(origins = "http://localhost:8085")
public class SessionManagerController {

	public static final Logger LOG = LoggerFactory.getLogger(SessionManagerController.class);

	/**
	 * Set session parameters from provided map
	 * 
	 * @param req
	 *            Http Request
	 * @param params
	 *            Map with session parameters
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void setSessionParameters(HttpServletRequest req, @RequestBody Map<String, String> params) {
		HttpSession session = req.getSession();
		for (Entry<String, String> entry : params.entrySet())
			session.setAttribute(entry.getKey(), entry.getValue());
	}

	/**
	 * Get Session attribute
	 * 
	 * @param req
	 *            Http Request
	 * @param key
	 *            Attribute name
	 * 
	 * @return Value (if any) for given session attribute
	 */
	@RequestMapping(path = "/{key}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getSessionKey(HttpServletRequest req, @PathVariable("key") String key) {
		HttpSession session = req.getSession(false);
		LOG.info("Getting parameter '" + key + "'" + 
				(session != null ? " from session " + session.getId() : ""));
		return session != null ? "" + session.getAttribute(key) : "";
	}
}
