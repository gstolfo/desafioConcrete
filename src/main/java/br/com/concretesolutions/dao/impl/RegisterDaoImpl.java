package br.com.concretesolutions.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.concretesolutions.beans.PhoneBean;
import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.beans.RegisterDetailBean;
import br.com.concretesolutions.dao.RegisterDaoI;
import br.com.concretesolutions.hibernate.HibernateFactory;
import br.com.concretesolutions.jwt.impl.JwtTokenI;
import br.com.concretesolutions.uuid.IUUID;

/**
 * RegisterDaoImpl
 * 
 * @author guilhermeluizstolfo
 *
 */

@Repository
public class RegisterDaoImpl implements RegisterDaoI {

	@Autowired
	private IUUID uuidCreate;

	@Autowired
	private JwtTokenI jwtToken;

	@Override
	public String register(RegisterBean registerBean) throws IOException, AclFormatException {

		Session session = HibernateFactory.getInstance().getSessionFactory();

		Transaction tx = session.beginTransaction();

		try {
			if (getByEmail(registerBean.getEmail()) == null) {
				
				//Register
				RegisterBean register = new RegisterBean();

				register.setId(uuidCreate.getUUID());
				register.setName(registerBean.getName());
				register.setEmail(registerBean.getEmail());
				register.setPassword(registerBean.getPassword());
								
				//RegisterDetail
				RegisterDetailBean registerDetailBean = new RegisterDetailBean();
				registerDetailBean.setId(uuidCreate.getUUID());
				registerDetailBean.setRegisterBean(register);
				registerDetailBean.setCreated(new Date());
				registerDetailBean.setModified(new Date());
				registerDetailBean.setLast_login(new Date());
				registerDetailBean.setToken(jwtToken.createTokenForUser(registerBean));
				
				List<PhoneBean> phonesRegisterList = registerBean.getPhones();

				List<PhoneBean> phonesBeanList = new ArrayList<PhoneBean>();

				// Get PhonesBeanRegisterList
				if (phonesRegisterList != null && phonesRegisterList.size() != 0) {

					for (PhoneBean phone : phonesRegisterList) {
						PhoneBean phonesBean = new PhoneBean();

						phonesBean.setId(uuidCreate.getUUID());
						phonesBean.setDdd(phone.getDdd());
						phonesBean.setNumber(phone.getNumber());

						phonesBeanList.add(phonesBean);
					}
				}

				register.setPhones(phonesBeanList);

				session.saveOrUpdate(register);

				tx.commit();
			} else {
				return RegisterDaoI.ERROR_EMAIL_EXISTS;
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				rbe.printStackTrace();
			}
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return RegisterDaoI.SUCCESS;
	}


	@Override
	public RegisterBean getById(String id) throws IOException, AclFormatException {
		Session session = HibernateFactory.getInstance().getSessionFactory();

		RegisterBean RegisterBean = session.get(RegisterBean.class, id);

		return RegisterBean;
	}

	@Override
	public RegisterBean getByEmailAndPassword(String email, String password) throws IOException, AclFormatException {

		Session session = HibernateFactory.getInstance().getSessionFactory();

		Criteria crit = session.createCriteria(RegisterBean.class);

		crit.add(Restrictions.eq("email", email));

		crit.add(Restrictions.eq("password", password));

		List<RegisterBean> list = crit.list();

		RegisterBean RegisterBean = null;
		if (list != null && list.size() != 0) {
			RegisterBean = (RegisterBean) list.get(0);
		}

		return RegisterBean;

	}

	@Override
	public RegisterBean getByEmail(String email) throws IOException, AclFormatException {
		Session session = HibernateFactory.getInstance().getSessionFactory();

		Criteria crit = session.createCriteria(RegisterBean.class);

		crit.add(Restrictions.like("email", email));

		List<RegisterBean> list = crit.list();

		RegisterBean RegisterBean = null;
		if (list != null && list.size() != 0) {
			RegisterBean = (RegisterBean) list.get(0);
		}

		return RegisterBean;

	}

	@Override
	public RegisterBean getByPassword(String password) throws IOException, AclFormatException {
		Session session = HibernateFactory.getInstance().getSessionFactory();

		Criteria crit = session.createCriteria(RegisterBean.class);

		crit.add(Restrictions.eq("password", password));

		List<RegisterBean> list = crit.list();

		RegisterBean RegisterBean = null;
		if (list != null && list.size() != 0) {
			RegisterBean = (RegisterBean) list.get(0);
		}

		return RegisterBean;
	}
	
	@Override
	public List<RegisterBean> getAll() throws IOException, AclFormatException {
		Session session = HibernateFactory.getInstance().getSessionFactory();
		
		List<RegisterBean> listRegisterBean = session.createCriteria(RegisterBean.class).list();
		
		return listRegisterBean;
	}


	@Override
	public RegisterBean getRegisterBean(RegisterBean registerBean) throws IOException, AclFormatException {
		Session session = HibernateFactory.getInstance().getSessionFactory();

		Criteria crit = session.createCriteria(RegisterBean.class);
		
		crit.add(Restrictions.eq("email", registerBean.getEmail()));
		
		crit.add(Restrictions.eq("email", registerBean.getPassword()));
		
		List<RegisterBean> list = crit.list();
		
		if(list != null && list.size() != 0){
			return (RegisterBean)list.get(0);
		}
		
		return null;
	}

}
