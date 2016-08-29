package br.com.concretesolutions.dao.impl;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.stereotype.Repository;

import br.com.concretesolutions.beans.LoginBean;
import br.com.concretesolutions.dao.LoginDaoI;
import br.com.concretesolutions.hibernate.HibernateFactory;

@Repository
public class LoginDaoImpl implements LoginDaoI {

	@Override
	public List<LoginBean> getAll() throws IOException, AclFormatException {
		Session session = HibernateFactory.getInstance().getSessionFactory();
		
		List<LoginBean> listLoginBean = session.createCriteria(LoginBean.class).list();
		
		return listLoginBean;
	}

	@Override
	public LoginBean getById(String id) throws IOException, AclFormatException {
		Session session = HibernateFactory.getInstance().getSessionFactory();
		
		LoginBean loginBean = session.get(LoginBean.class, id);
		
		return loginBean;
	}

	@Override
	public LoginBean getByEmailAndPassword(String email, String password) throws IOException, AclFormatException {
		
		Session session = HibernateFactory.getInstance().getSessionFactory();
		
		Criteria crit = session.createCriteria(LoginBean.class);
		
		crit.add(Restrictions.eq("email",email));
		
		crit.add(Restrictions.eq("password",password));

		List<LoginBean> list = crit.list();
		
		LoginBean loginBean = null;
		if(list != null && list.size() != 0){
			 loginBean = (LoginBean)list.get(0);
		}
		
		return loginBean;
		
	}

	@Override
	public LoginBean getByEmail(String email) throws IOException, AclFormatException {
		Session session = HibernateFactory.getInstance().getSessionFactory();
		
		Criteria crit = session.createCriteria(LoginBean.class);
		
		crit.add(Restrictions.like("email",email));
		
		List<LoginBean> list = crit.list();
		
		LoginBean loginBean = null;
		if(list != null && list.size() != 0){
			 loginBean = (LoginBean)list.get(0);
		}
		
		return loginBean;
		
	}

	@Override
	public LoginBean getByPassword(String password) throws IOException, AclFormatException {
		Session session = HibernateFactory.getInstance().getSessionFactory();
		
		Criteria crit = session.createCriteria(LoginBean.class);
		
		crit.add(Restrictions.eq("password",password));
		
		List<LoginBean> list = crit.list();
		
		LoginBean loginBean = null;
		if(list != null && list.size() != 0){
			 loginBean = (LoginBean)list.get(0);
		}
		
		return loginBean;
	}	
	
}
