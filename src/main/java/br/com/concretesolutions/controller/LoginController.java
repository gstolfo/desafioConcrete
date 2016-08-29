package br.com.concretesolutions.controller;

import java.io.IOException;

import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.concretesolutions.beans.ResponseBean;
import br.com.concretesolutions.pojo.Login;
import br.com.concretesolutions.service.RegisterServiceI;

/**
 * LoginController
 * @author guilhermeluizstolfo
 *
 */
@RestController
public class LoginController {

	@Autowired
	RegisterServiceI registerService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseBean<Login> login( @RequestBody Login Login) throws IOException, AclFormatException {
		
		if(registerService.getByEmail(Login.getEmail()) != null){
		
			if(Login.getEmail() != null && !Login.getEmail().isEmpty()){
				
				if( registerService.getByPassword(Login.getPassword() ) != null && !Login.getPassword().isEmpty() ){
				
					if(registerService.getByEmailAndPassword(Login.getEmail(), Login.getPassword()) != null){
						return new ResponseBean<Login>("Logado", HttpStatus.OK, HttpStatus.OK.value());	
					} else {
						return new ResponseBean<Login>("Usuário e/ou senha inválidos", HttpStatus.UNAUTHORIZED,  HttpStatus.UNAUTHORIZED.value());
					}
				} else {
					return new ResponseBean<Login>("Usuário e/ou senha inválidos", HttpStatus.UNAUTHORIZED,  HttpStatus.UNAUTHORIZED.value());
				}
			}
		} else{
			return new ResponseBean<Login>("Usuário e/ou senha inválidos", HttpStatus.UNAUTHORIZED,  HttpStatus.UNAUTHORIZED.value());
		}
		
		return new ResponseBean<Login>("", HttpStatus.OK,  HttpStatus.OK.value());		
	}
 
}