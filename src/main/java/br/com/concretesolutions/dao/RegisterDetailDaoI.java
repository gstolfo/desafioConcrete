package br.com.concretesolutions.dao;

import java.io.IOException;

import org.hsqldb.server.ServerAcl.AclFormatException;

import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.beans.RegisterDetailBean;

/**
 * DAO Register Detail Interface
 * @author guilhermeluizstolfo
 *
 */
public interface RegisterDetailDaoI {	
	public RegisterDetailBean getRegisterDetailBean(RegisterBean registerBean, RegisterDetailBean registerDetailBean) throws IOException, AclFormatException;

}
