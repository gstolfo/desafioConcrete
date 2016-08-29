package br.com.concretesolutions.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.concretesolutions.beans.PhonesBean;
import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.dao.RegisterDaoI;
import br.com.concretesolutions.hibernate.HibernateFactory;
import br.com.concretesolutions.uuid.IUUID;

@Repository
public class RegisterDaoImpl implements RegisterDaoI {

	@Autowired
	private IUUID uuidCreate; 	
	
	@Override
	public String register(RegisterBean registerBean) throws IOException, AclFormatException {

		Session session = HibernateFactory.getInstance().getSessionFactory();
		
		Transaction tx = session.beginTransaction();
		
		try {
			RegisterBean register = new RegisterBean();
				
			register.setId(uuidCreate.getUUID());
			register.setName(registerBean.getName());
			register.setEmail(registerBean.getEmail());
			register.setPassword(registerBean.getPassword());
			
			List<PhonesBean> phonesRegisterList = registerBean.getPhones();
			
			List<PhonesBean> phonesBeanList = new ArrayList<PhonesBean>();
			
			//Get PhonesBeanRegisterList
			if(phonesRegisterList != null && phonesRegisterList.size() != 0){
				
				for(PhonesBean phone : phonesRegisterList){
					PhonesBean phonesBean = new PhonesBean();
					
					phonesBean.setId(uuidCreate.getUUID());
					phonesBean.setDdd(phone.getDdd());
					phonesBean.setNumber(phone.getNumber());
					
					phonesBeanList.add(phonesBean);	
				}	
			}
			
			
			register.setPhones(phonesBeanList);
			
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
	
		return "SUCCESS";
	}

}
