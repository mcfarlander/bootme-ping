package org.djohnson.bootme.ping;

import org.djohnson.bootme.ping.exception.PingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	
	@Autowired
	WebAuthenticationEntryPoint webAuthenticationEntryPoint;
	
	@Autowired
	WebRequestFilter webRequestFilter;
	
	@Bean
	public UserDetailsService userDetailsService() {
	    return super.userDetailsService();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws PingException {
		
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		try {
			auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
		} catch (Exception e) {
			throw new PingException("Security", e);
		}
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// don't authenticate this particular request
				.authorizeRequests().antMatchers("/api/**").permitAll().
				// all other requests need to be authenticated
				anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(webAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(webRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	  
}
