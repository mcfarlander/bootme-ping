package org.djohnson.bootme.ping.exception;

/**
 * Custom exception for the Ping web service.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class PingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create a new instance of PingException.
	 * 
	 * @param message	the message for the exception
	 * @param ex		the exception
	 */
	public PingException(String message, Throwable ex) {
		super(message, ex);
		
	}
	
}
