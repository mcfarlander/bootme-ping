package org.djohnson.bootme.ping.controller;

import org.djohnson.bootme.ping.exception.PingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The centralized error handler for the controllers.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@ControllerAdvice
public class PingExceptionController {
	
	@ExceptionHandler(value = PingException.class)
	public ResponseEntity<Object> exception(PingException exception) {
	      return new ResponseEntity<>("Bootme Ping Error " + exception.getMessage(), HttpStatus.OK);
	}

}
