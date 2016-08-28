package br.com.concretesolutions.spring;

import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;

import br.com.concretesolutions.beans.Login;
import br.com.concretesolutions.beans.Register;
import br.com.conretesolutions.database.hibernate.Hibernate;

/**
 * Create tables in memory
 * @author guilhermeluizstolfo
 *
 */
public class CreateTablesInMemory implements InitializingBean{

	
	Hibernate hibernate = new Hibernate();
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Session session = hibernate.getSessionFactory();
		
		session.beginTransaction();
		
		hibernate.commit();
		
		session.close();	
	}

}
