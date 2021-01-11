package org.djohnson.bootme.ping.model;

import java.io.Serializable;

/**
 * A class to contain a JWT.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class VerifyTokenDTO implements Serializable {

	private static final long serialVersionUID = 794876484788822323L;
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * Create a new instance of VerifyTokenDTO.
	 */
	public VerifyTokenDTO() {
		
	}
	
	/**
	 * Create a new instance of VerifyTokenDTO
	 * 
	 * @param token the string token to set this class to
	 */
	public VerifyTokenDTO(String token) {
		this.token = token;
	}

}
