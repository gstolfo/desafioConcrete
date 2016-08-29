package br.com.concretesolutions.junit;

import static org.junit.Assert.*;

import java.io.IOException;

import org.hsqldb.server.ServerAcl.AclFormatException;
import org.junit.Test;

import br.com.concretesolutions.beans.ResponseBean;
import br.com.concretesolutions.controller.LoginController;
import br.com.concretesolutions.hibernate.StartHsqldb;
import br.com.concretesolutions.pojo.Login;

/**
 * LoginTest
 * @author guilhermeluizstolfo
 *
 */
public class LoginTest {
	
	@Test
	public void testLogin() throws IOException, AclFormatException{
		
		StartHsqldb.getInstance().startHsqldb();
		
		LoginController loginController = new LoginController();
		
		Login login = new Login();
		
		login.setEmail("stolfo@gmail.com");
		login.setPassword("123456");
		
		ResponseBean<Login> responseBean = loginController.login(login);
		
		
		assertEquals(responseBean.getCodHttpStatus(),200);
		assertEquals(responseBean.getHttpStatus(),"OK");
		 
		
	}
}
