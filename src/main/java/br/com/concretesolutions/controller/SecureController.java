package br.com.concretesolutions.controller;

import java.io.IOException;

import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.beans.ResponseBean;

@RestController
public class SecureController {

	@RequestMapping(value = "/secure", method = RequestMethod.GET)
	public ResponseBean<RegisterBean> secure( @RequestBody Object request) throws IOException, AclFormatException {
		
		return new ResponseBean<RegisterBean>("", HttpStatus.OK, HttpStatus.OK.value());
	}
	
	
}
