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
		
		String id = "";

		
		if(loginService.getByEmail(request.getEmail()) != null){
		
			if(request.getEmail() != null && !request.getEmail().isEmpty()){
				
				if( loginService.getByPassword(request.getPassword() ) != null && !request.getPassword().isEmpty() ){
				
					if(loginService.getByEmailAndPassword(request.getEmail(), request.getPassword()) != null){
						//Get LoginBean
						LoginBean loginBean = loginService.getById(id);
					} else {
						System.out.println("Usuario ou senha Invalido");
					}
				} else {
					System.out.println("Usuario ou senha Invalido");
				}
			}
		} else{
			System.out.println("Usuario ou senha Invalido");
		}
		
		
	}
 
}