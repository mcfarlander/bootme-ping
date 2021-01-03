package org.djohnson.bootme.ping.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JWT utility class.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -587878667257106309L;
	
	// The JWT will valid for 5 hrs: (60 secs/min * 60 min/hr) 
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;
	
	/**
	 * Get the user's name from the token.
	 * 
	 * @param token the JWT
	 * @return the user's name
	 */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	/**
	 * Get the expiration time from the token.
	 * 
	 * @param token the JWT to use
	 * @return the expiration time
	 */
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	/**
	 * Get a list of claims from the token.
	 * 
	 * @param <T> function to use to get the claims
	 * @param token the JWT to use
	 * @param claimsResolver the resolver
	 * @return
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	/**
	 * Get all the claims from the token. The JWT secret must be known.
	 * 
	 * @param token the JWT to use
	 * @return {@link Claims}
	 */
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	/**
	 * Determine if the JWT has expired.
	 * 
	 * @param token the JWT to use
	 * @return true if expired, false otherwise
	 */
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	/**
	 * Create a JWT for the user.
	 * 
	 * @param userDetails {@link UserDetails}
	 * @return JWT string
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	//while creating the token -
	//1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
	//2. Sign the JWT using the HS512 algorithm and secret key.
	//3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	//   compaction of the JWT to a URL-safe string 
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	/**
	 * Validate the JWT based on the token and the user.
	 * @param token the JWT to use
	 * @param {@link UserDetails} the user's details
	 * @return true if the user information matches what is in the JWT, false otherwise
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	

}
