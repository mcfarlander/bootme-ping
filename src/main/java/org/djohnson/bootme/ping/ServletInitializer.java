package org.djohnson.bootme.ping;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The servlet initializer. Not strictly necessary for a spring boot application.
 * For more information, see {@link SpringBootServletInitializer}.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BootmePingApplication.class);
	}

}
