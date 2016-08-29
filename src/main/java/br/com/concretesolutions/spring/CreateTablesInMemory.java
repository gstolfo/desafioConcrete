package br.com.concretesolutions.spring;

import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.concretesolutions.beans.LoginBean;
import br.com.concretesolutions.hibernate.HibernateFactory;
import br.com.concretesolutions.hibernate.StartHsqldb;
import br.com.concretesolutions.uuid.IUUID;

/**
 * Create tables in memory
 * @author guilhermeluizstolfo
 *
 */

public class CreateTablesInMemory implements InitializingBean{
	
	@Autowired
	IUUID uuidCreate; 	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		//Start Service HSQLDB
		//StartHsqldb.getInstance().startHsqldb();
		
		Session session = HibernateFactory.getInstance().getSessionFactory();
		
		LoginBean login = new LoginBean();
			
		login.setId(uuidCreate.getUUID());
		login.setEmail("stolfo@gmail.com");
		login.setPassword("123456");
		
		session.saveOrUpdate(login);		
		
		session.beginTransaction().commit();
		
		session.close();	
	}

}
