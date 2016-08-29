package br.com.concretesolutions.dao.impl;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.stereotype.Repository;

import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.beans.RegisterDetailBean;
import br.com.concretesolutions.dao.RegisterDetailDaoI;
import br.com.concretesolutions.hibernate.HibernateFactory;

/**
 * RegisterDetailDaoImpl
 * 
 * @author guilhermeluizstolfo
 *
 */

@Repository
public class RegisterDetailDaoImpl implements RegisterDetailDaoI {


	@Override
	public RegisterDetailBean getRegisterDetailBean(RegisterBean registerBean, RegisterDetailBean registerDetailBean) throws IOException, AclFormatException {
		Session session = HibernateFactory.getInstance().getSessionFactory();

		Criteria crit = session.createCriteria(RegisterDetailBean.class);
		
		crit.createAlias("registerBean", "t");
		
		crit.add(Restrictions.eq("t.email", registerBean.getEmail()));
		
		crit.add(Restrictions.eq("t.password", registerBean.getPassword()));
		
		List<RegisterDetailBean> list = crit.list();
		
		if(list != null && list.size() != 0){
			return (RegisterDetailBean)list.get(0);
		}
		
		return null;
	}

}
