package org.djohnson.bootme.ping.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import org.djohnson.bootme.ping.exception.PingException;
import org.djohnson.bootme.ping.jwt.JwtResponse;
import org.djohnson.bootme.ping.jwt.JwtTokenUtil;
import org.djohnson.bootme.ping.model.LoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The ping controller is the main controller for communication with the companion web application.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class PingController {
	
	private static final Logger logger = LoggerFactory.getLogger(PingController.class);
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	/**
	 * The ping method for the web application. A GET request that returns the bootme ping message with a date.
	 * 
	 * @return message with the current date
	 */
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String index() {
		
		logger.debug("accessing bootme ping GET");
		return "bootme ping " + new Date();
		
	}
	
	/**
	 * The authenticate method for the web application. A POST request that returns a JWT with basic claims.
	 * 
	 * @return JWT with basic claims 
	 * @throws PingException 
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> generateAuthenticationToken(@RequestBody LoginDTO login) throws PingException {
		
		logger.debug("accessing bootme generateAuthenticationToken POST");
		
		Objects.requireNonNull(login.getUsername());
		Objects.requireNonNull(login.getSecret());
		
		final UserDetails userDetails =  new User(login.getUsername(), login.getSecret(), new ArrayList<>());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
}
