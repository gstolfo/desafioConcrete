package br.com.concretesolutions.dao.impl;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
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
		
		return session.createCriteria(LoginBean.class).list();
	}

}
