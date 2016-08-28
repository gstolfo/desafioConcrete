package br.com.concretesolutions.hibernate;

import org.hibernate.Session;

/**
 * Interface Hibernate
 * @author guilhermeluizstolfo
 *
 */
public interface IHibernateFactory {

	public Session getSessionFactory();
}
