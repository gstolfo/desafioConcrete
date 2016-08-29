package br.com.concretesolutions.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.concretesolutions.beans.PhoneBean;
import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.beans.RegisterDetailBean;
import br.com.concretesolutions.hibernate.HibernateFactory;
import br.com.concretesolutions.jwt.impl.JwtTokenI;
import br.com.concretesolutions.uuid.IUUID;

/**
 * Create tables in memory
 * @author guilhermeluizstolfo
 *
 */
@Repository
public class CreateTablesInMemory implements InitializingBean{
	
	@Autowired
	private IUUID uuidCreate; 	
	
	@Autowired
	private JwtTokenI jwtToken;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		//Start Service HSQLDB
		//StartHsqldb.getInstance().startHsqldb();
		
		Session session = HibernateFactory.getInstance().getSessionFactory();
		Transaction tx = session.beginTransaction();
		
		try {
			
			RegisterBean register = new RegisterBean();
				
			register.setId(uuidCreate.getUUID());
			register.setName("Guilherme Luiz Stolfo");
			register.setEmail("stolfo@gmail.com");
			register.setPassword("123456");
			
			List<PhoneBean> phoneBeanList =new ArrayList<PhoneBean>();
			
			PhoneBean phoneBean = new PhoneBean();
			phoneBean.setId(uuidCreate.getUUID());
			phoneBean.setDdd(11);
			phoneBean.setNumber("992483773");
			
			phoneBeanList.add(phoneBean);
			
			register.setPhones(phoneBeanList);
			
			//RegisterDetail
			RegisterDetailBean registerDetailBean = new RegisterDetailBean();
			
			registerDetailBean.setId(uuidCreate.getUUID());
			registerDetailBean.setRegisterBean(register);
			registerDetailBean.setCreated(new Date());
			registerDetailBean.setModified(new Date());
			registerDetailBean.setLast_login(new Date());
			registerDetailBean.setToken(jwtToken.createTokenForUser(register));
			
			session.saveOrUpdate(registerDetailBean);
			session.saveOrUpdate(register);		
					
			
			tx.commit();
			
		} catch(RuntimeException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
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
