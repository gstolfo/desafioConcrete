package br.com.concretesolutions.controller.login;

import java.io.IOException;
import java.util.List;

import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.concretesolutions.beans.LoginBean;
import br.com.concretesolutions.service.LoginServiceI;


@RestController
public class LoginController {

	@Autowired
	LoginServiceI loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login( @RequestBody LoginBean request) throws IOException, AclFormatException {
		
		
		List<LoginBean> list = loginService.getAll();
		
		LoginBean loginBean = new LoginBean();
		
		//loginBean.setEmail();
		
		
		
		
	}
 
}