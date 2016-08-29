package br.com.concretesolutions.jwt;

import java.time.Instant;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

public class JWTToken {
	
	
	
	public static void main(String args[]){
		JWTToken jwtToken = new JWTToken();
		
		
		String token = jwtToken.createTokenForUser();
		System.out.println(token);
		jwtToken.parseUserFromToken(token);
	}
	
	
	public String createTokenForUser() {
		return Jwts.builder()
				.setId("15")
				.setIssuer("login")
				.setSubject("gstolfo")
				// Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
				  .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
				  // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
				  .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
				.claim("name", "Micah Silverman")
				.claim("scope", "admins")
				.signWith(SignatureAlgorithm.HS256, "REDSPARK_SECRET").compact();
	}
	
	public void parseUserFromToken(String token) {
		Jws<Claims> jws = Jwts.parser().setSigningKey("REDSPARK_SECRET").parseClaimsJws(token);
		
		System.out.println(jws.getBody().getId());
		System.out.println(jws.getBody().getIssuer());
		System.out.println(jws.getBody().getSubject());
		System.out.println(jws.getBody().getExpiration());	
		
		System.out.println(TextCodec.BASE64.decode(jws.getSignature()));
	}
}
