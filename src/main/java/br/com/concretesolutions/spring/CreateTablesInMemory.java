package br.com.concretesolutions.spring;

import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.concretesolutions.beans.Login;
import br.com.concretesolutions.uuid.UUIDI;
import br.com.conretesolutions.hibernate.Hibernate;

/**
 * Create tables in memory
 * @author guilhermeluizstolfo
 *
 */
public class CreateTablesInMemory implements InitializingBean{

	
	Hibernate hibernate = new Hibernate();
	
	@Autowired
	UUIDI uuidCreate; 
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Session session = hibernate.getSessionFactory();
		
		Login login = new Login();
			
		login.setId(uuidCreate.getUUID());
		login.setEmail("stolfo@gmail.com");
		login.setPassword("123456");
		
		session.save(login);		
		
		session.beginTransaction().commit();
		
		session.close();	
	}

}
