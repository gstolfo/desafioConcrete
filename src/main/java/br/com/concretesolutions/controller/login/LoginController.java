package br.com.concretesolutions.controller.login;

import java.io.IOException;

import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.concretesolutions.beans.LoginBean;
import br.com.concretesolutions.beans.ResponseBean;
import br.com.concretesolutions.service.LoginServiceI;

/**
 * LoginController
 * @author guilhermeluizstolfo
 *
 */
@RestController
public class LoginController {

	@Autowired
	LoginServiceI loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseBean<LoginBean> login( @RequestBody LoginBean loginBean) throws IOException, AclFormatException {

		loginService.getAll();
		
		if(loginService.getByEmail(loginBean.getEmail()) != null){
		
			if(loginBean.getEmail() != null && !loginBean.getEmail().isEmpty()){
				
				if( loginService.getByPassword(loginBean.getPassword() ) != null && !loginBean.getPassword().isEmpty() ){
				
					if(loginService.getByEmailAndPassword(loginBean.getEmail(), loginBean.getPassword()) != null){
						return new ResponseBean<LoginBean>("Logado", HttpStatus.OK, HttpStatus.OK.value());	
					} else {
						return new ResponseBean<LoginBean>("Usuário e/ou senha inválidos", HttpStatus.UNAUTHORIZED,  HttpStatus.UNAUTHORIZED.value());
					}
				} else {
					return new ResponseBean<LoginBean>("Usuário e/ou senha inválidos", HttpStatus.UNAUTHORIZED,  HttpStatus.UNAUTHORIZED.value());
				}
			}
		} else{
			return new ResponseBean<LoginBean>("Usuário e/ou senha inválidos", HttpStatus.UNAUTHORIZED,  HttpStatus.UNAUTHORIZED.value());
		}
		
		return new ResponseBean<LoginBean>("", HttpStatus.OK,  HttpStatus.OK.value());		
	}
 
}