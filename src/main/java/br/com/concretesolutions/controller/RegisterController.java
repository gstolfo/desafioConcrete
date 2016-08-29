package br.com.concretesolutions.controller;

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
		
		String resultMsg = registerService.register(registerBean);
		
		if(resultMsg.equals("success")){
			return new ResponseBean<RegisterBean>("Registrado com Sucesso!", HttpStatus.OK, HttpStatus.OK.value());
		} else if(resultMsg.equals("error_email_exists")){
			return new ResponseBean<RegisterBean>("E-mail já existente", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		}
		
		return new ResponseBean<RegisterBean>("", HttpStatus.OK, HttpStatus.OK.value());
	}
}
