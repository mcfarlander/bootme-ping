package org.djohnson.bootme.ping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The main method for the spring boot application. Spring components, beans and services
 * will be scanned under this package.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"org.djohnson.bootme.ping"})
public class BootmePingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootmePingApplication.class, args);
	}

}
