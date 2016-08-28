package br.com.concretesolutions.hibernate.impl;


import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hsqldb.server.ServerAcl.AclFormatException;

import br.com.concretesolutions.hibernate.HibernateFactory;
import br.com.concretesolutions.hibernate.HibernateTemplateI;

/**
 * HibernateTemplate 
 * @author guilhermeluizstolfo
 *
 */
public class HibernateTemplateImpl<T> implements HibernateTemplateI{
	
	private static HibernateTemplateImpl instance = null;
	
	@Override
	public List<Object> getAll(Object object) throws IOException, AclFormatException {

		return null;
	}

	@Override
	public <T> T getById(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T save(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static HibernateTemplateImpl getInstance(){
		if(instance == null){
			instance = new HibernateTemplateImpl();
		}
		return instance;
	}
	
}
