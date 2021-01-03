package org.djohnson.bootme.ping.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The ping controller is the main controller for communication with the companion web application.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@RestController
public class PingController {
	
	private static final Logger logger = LoggerFactory.getLogger(PingController.class);

	/**
	 * The hello method for the web application.
	 * 
	 * @return message with the current date
	 */
	@RequestMapping("/ping")
	public String index() {
		logger.debug("accessing ping GET controller");
		return "bootme ping " + new Date();
	}

}
