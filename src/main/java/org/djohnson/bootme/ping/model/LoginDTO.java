package org.djohnson.bootme.ping.model;

import java.io.Serializable;

/**
 * A login object consisting of a user name and password.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class LoginDTO implements Serializable {
	

	private static final long serialVersionUID = -4939061414907215132L;
	
	private String username;
	private String secret;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSecret() {
		return secret;
	}
	
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	/**
	 * Create a new instance of LoginDTO.
	 */
	public LoginDTO() {
		
	}
	
	/**
	 * Create a new instance of LoginDTO.
	 * 
	 * @param username	the user's name
	 * @param secret	the user's secret
	 */
	public LoginDTO(String username, String secret) {
		this.username = username;
		this.secret = secret;
	}
	
}
