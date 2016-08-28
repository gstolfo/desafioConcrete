package br.com.concretesolutions.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
	
	@RequestMapping(value = "/test/", method = RequestMethod.GET)
	public String listAllUsers() {
		return "Hello";
	}
 
}
