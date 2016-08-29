package br.com.concretesolutions.jwt;

import java.util.Date;

import org.springframework.stereotype.Repository;

import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.jwt.impl.JwtTokenI;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

/**
 * JWTToken
 * @author guilhermeluizstolfo
 *
 */
@Repository
public class JWTTokenImpl implements JwtTokenI{
	
	/*
	public static void main(String args[]){
		JWTToken jwtToken = new JWTToken();
		String token = jwtToken.createTokenForUser();
		System.out.println(token);
		jwtToken.parseUserFromToken(token);
	}
	*/
	
	public String createTokenForUser(RegisterBean registerBean) {
				
		//Builder
		return Jwts.builder()
		
		//Header
		.setId(registerBean.getId())
		.setIssuer("register")
		.setSubject(registerBean.getEmail())
		.setIssuedAt(new Date())
		.setExpiration(new Date())
		
		//Payload
		.claim("name", registerBean.getName())
		.claim("scope", "user")
		
		//Signature
		.signWith(SignatureAlgorithm.HS256, JwtTokenI.SECRET).compact();
	}
	
	public void parseUserFromToken(String token) {
		Jws<Claims> jws = Jwts.parser().setSigningKey(JwtTokenI.SECRET).parseClaimsJws(token);
		
		System.out.println(jws.getBody().getId());
		System.out.println(jws.getBody().getIssuer());
		System.out.println(jws.getBody().getSubject());
		System.out.println(jws.getBody().getExpiration());	
		
		System.out.println(TextCodec.BASE64.decode(jws.getSignature()));
	}
}
