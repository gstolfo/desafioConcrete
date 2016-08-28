package br.com.concretesolutions.spring;

import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.concretesolutions.beans.Login;
import br.com.concretesolutions.hibernate.IHibernateFactory;
import br.com.concretesolutions.uuid.IUUID;

/**
 * Create tables in memory
 * @author guilhermeluizstolfo
 *
 */

public class CreateTablesInMemory implements InitializingBean{

	@Autowired
	IHibernateFactory hibernateFactory;
	
	@Autowired
	IUUID uuidCreate; 	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Session session = hibernateFactory.getSessionFactory();
		
		Login login = new Login();
			
		login.setId(uuidCreate.getUUID());
		login.setEmail("stolfo@gmail.com");
		login.setPassword("123456");
		
		session.save(login);		
		
		session.beginTransaction().commit();
		
		session.close();	
	}

}
