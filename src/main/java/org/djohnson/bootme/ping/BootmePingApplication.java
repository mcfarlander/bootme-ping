package org.djohnson.bootme.ping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"org.djohnson.bootme.ping"})
public class BootmePingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootmePingApplication.class, args);
	}

}
