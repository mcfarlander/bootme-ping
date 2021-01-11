package org.djohnson.bootme.ping.jwt;

import java.io.Serializable;

/**
 * A class to represent a response to the verify token request.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class VerifyResponse implements Serializable {

	private static final long serialVersionUID = 4796623312499159408L;
	
	private boolean verified;
	
	/**
	 * Create a new instance of VerifyResponse.
	 * 
	 * @param verified flag if the token is valid 
	 */
	public VerifyResponse(boolean verified) {
		this.verified = verified;
	}

	/**
	 * Get the flag if the token is verfied.
	 * 
	 * @return true if the token is valid, false otherwise
	 */
	public boolean getVerified() {
		return this.verified;
	}

}
