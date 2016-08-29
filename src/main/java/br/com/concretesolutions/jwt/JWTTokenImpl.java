package br.com.concretesolutions.jwt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Repository;

import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.jwt.impl.JwtTokenI;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JWTToken
 * @author guilhermeluizstolfo
 *
 */
@Repository
public class JWTTokenImpl implements JwtTokenI{
	
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
	
	public boolean parseUserFromToken(String token) {
		
		try{
			Jws<Claims> jws = Jwts.parser().setSigningKey(JwtTokenI.SECRET).parseClaimsJws(token); // valid expiration
			
			if( jws.getBody().getId() != null && 
					jws.getBody().getIssuer() != null && 
					jws.getBody().getSubject() != null && 
					jws.getBody().getExpiration() != null && 
					jws.getBody().getIssuedAt() != null &&
					jws.getSignature() != null){
				return false;
			} else {
				return true;
			}
		} catch (Throwable e) {
			return false;
		}
	}
	
   public boolean returnDateExpiration(String token) {
		
		try{
			Jws<Claims> jws = Jwts.parser().setSigningKey(JwtTokenI.SECRET).parseClaimsJws(token); // valid expiration
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("mm");
			int minute = new Integer(sdf.format(jws.getBody().getExpiration()));
			
			if(minute > 30){
				return false;
			}
			return true;
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return false;
	}
   
}
