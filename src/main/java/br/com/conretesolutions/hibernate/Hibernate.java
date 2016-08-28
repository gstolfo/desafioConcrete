package br.com.conretesolutions.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hibernate{
	
	/**
	 *  Fabrica de sessão hibernate
	 */
	public Session getSessionFactory(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	    return sessionFactory.openSession();
	}   
    
	/**
	 * Transação
	 */
	public Transaction getTransaction(){
		Transaction tx = getSessionFactory().beginTransaction();		
	    return tx;
	}
	
	/**
	 * Commit
	 */
	public void commit(){
		getTransaction().commit();
	    getSessionFactory().close();
	}
	
	
}