package br.com.concretesolutions.controller.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {
	
	}
 
}