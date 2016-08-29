package br.com.concretesolutions.controller;

import java.io.IOException;

import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.beans.ResponseBean;
import br.com.concretesolutions.jwt.impl.JwtTokenI;
import br.com.concretesolutions.service.RegisterServiceI;

@RestController
public class SecureController {

	@Autowired
	RegisterServiceI registerService; 
	
	@Autowired
	JwtTokenI jwtToken;
	
	@RequestMapping(value = "/secure", method = RequestMethod.GET)
	public @ResponseBody ResponseBean<Object> secure(@RequestParam String token) throws IOException, AclFormatException {
		
		if(!token.isEmpty() && !token.equals("") && !token.equals(" ")){
			//Parse Token verify is valid
			if(jwtToken.parseUserFromToken(token)){
				//Verify Expiration
				if(jwtToken.returnDateExpiration(token)){
					return new ResponseBean<Object>("", HttpStatus.OK, HttpStatus.OK.value());
				} else{
					return new ResponseBean<Object>("Sessão Inválida", HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value());
				}
			} else {
				return new ResponseBean<Object>("Não Autorizado", HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value());
			}
		} else {
			return new ResponseBean<Object>("Não Autorizado", HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value());
		}
	}
	
}
