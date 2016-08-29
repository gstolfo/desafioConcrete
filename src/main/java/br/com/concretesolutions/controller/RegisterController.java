package br.com.concretesolutions.controller.login;

import java.io.IOException;

import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.beans.ResponseBean;
import br.com.concretesolutions.service.RegisterServiceI;

@RestController
public class RegisterController {

	@Autowired
	RegisterServiceI registerService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseBean<RegisterBean> register( @RequestBody RegisterBean registerBean) throws IOException, AclFormatException {
		
		registerService.register(registerBean);
		
		return new ResponseBean<RegisterBean>("", HttpStatus.OK, HttpStatus.OK.value());
	}
}
