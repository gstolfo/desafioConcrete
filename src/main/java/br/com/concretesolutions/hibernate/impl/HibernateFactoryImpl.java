package br.com.concretesolutions.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import br.com.concretesolutions.hibernate.IHibernateFactory;

@Repository
public class HibernateFactoryImpl implements IHibernateFactory{
	
	/**
	 *  Fabrica de sessão hibernate
	 */
	public Session getSessionFactory(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	    return sessionFactory.openSession();
	}   	
}