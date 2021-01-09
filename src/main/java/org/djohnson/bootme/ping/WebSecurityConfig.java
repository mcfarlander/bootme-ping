package org.djohnson.bootme.ping;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuration of web/http security.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		// for now, allow all endpoints, not optimal
		  web
	        .ignoring()
	        .antMatchers("/**");
	}
	  
}
