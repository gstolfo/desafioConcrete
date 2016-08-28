package br.com.concretesolutions.hibernate;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hsqldb.server.ServerAcl.AclFormatException;

/**
 * HibernateFactory
 * @author guilhermeluizstolfo
 *
 */
public class HibernateFactory {

	private static HibernateFactory instance = null;

	public Session getSessionFactory() throws IOException, AclFormatException{
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	    return sessionFactory.openSession();
	}   	
	
	public static HibernateFactory getInstance(){
		if(instance == null){
			instance = new HibernateFactory();
		}
		return instance;
	}
}