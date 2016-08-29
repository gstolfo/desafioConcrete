package br.com.concretesolutions.dao;

import java.io.IOException;

import org.hsqldb.server.ServerAcl.AclFormatException;

import br.com.concretesolutions.beans.RegisterBean;

/**
 * RegisterDao
 * @author guilhermeluizstolfo
 *
 */
public interface RegisterDaoI {
	public String register(RegisterBean registerBean) throws IOException, AclFormatException ;
}
