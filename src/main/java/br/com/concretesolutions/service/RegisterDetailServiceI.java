package br.com.concretesolutions.service;

import java.io.IOException;

import org.hsqldb.server.ServerAcl.AclFormatException;

import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.beans.RegisterDetailBean;

/**
 * Service
 * @author guilhermeluizstolfo
 *
 */
public interface RegisterDetailServiceI {
	public RegisterDetailBean getRegisterDetailBean(RegisterBean registerBean, RegisterDetailBean registerDetailBean) throws IOException, AclFormatException;
}
