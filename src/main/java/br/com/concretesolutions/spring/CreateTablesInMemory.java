package br.com.concretesolutions.spring;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.concretesolutions.beans.LoginBean;
import br.com.concretesolutions.hibernate.HibernateFactory;
import br.com.concretesolutions.uuid.IUUID;

/**
 * Create tables in memory
 * @author guilhermeluizstolfo
 *
 */

public class CreateTablesInMemory implements InitializingBean{
	
	@Autowired
	private IUUID uuidCreate; 	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		//Start Service HSQLDB
		//StartHsqldb.getInstance().startHsqldb();
		
		Session session = HibernateFactory.getInstance().getSessionFactory();
		Transaction tx = session.beginTransaction();
		
		try {
			
			LoginBean login = new LoginBean();
				
			login.setId(uuidCreate.getUUID());
			login.setEmail("stolfo@gmail.com");
			login.setPassword("123456");
			
			session.saveOrUpdate(login);		
			
			tx.commit();
			
		} catch(RuntimeException e){
			try {
				tx.rollback();
			} catch (RuntimeException rbe){
				rbe.printStackTrace();
			}
			throw e;
		} finally {
			if(session != null){
				session.close();
			}
		}
	}

}
