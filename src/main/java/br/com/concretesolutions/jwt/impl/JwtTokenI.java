package br.com.concretesolutions.jwt.impl;

import br.com.concretesolutions.beans.RegisterBean;

/**
 * JWTToken Interface
 * @author guilhermeluizstolfo
 *
 */
public interface JwtTokenI {
	
	public static final String SECRET = "concreteSolutions29/08/2016";
	
	public String createTokenForUser(RegisterBean registerBean);
	
	public boolean parseUserFromToken(String token);
	
	 public boolean returnDateExpiration(String token);
}
