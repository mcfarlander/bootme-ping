package org.djohnson.bootme.ping.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PingController {
	
	private static final Logger logger = LoggerFactory.getLogger(PingController.class);

	@RequestMapping("/")
	public String index() {
		logger.debug("accessing ping GET controller");
		System.out.println("access ping GET controller");
		return "bootme ping " + new Date();
	}

}
