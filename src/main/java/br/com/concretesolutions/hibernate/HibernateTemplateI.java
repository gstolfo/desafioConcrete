package br.com.concretesolutions.hibernate;

import java.io.IOException;
import java.util.List;

import org.hsqldb.server.ServerAcl.AclFormatException;

/**
 * Interface HibernateTemplateI
 * @author guilhermeluizstolfo
 *
 */
public interface HibernateTemplateI {
	public List<Object> getAll(Object object) throws IOException, AclFormatException ;
	
	public <T>T getById(Class<T> clazz);
	
	public <T>T save(Class<T> clazz);
}
