package br.com.concretesolutions.service;

import java.io.IOException;
import java.util.List;

import org.hsqldb.server.ServerAcl.AclFormatException;

import br.com.concretesolutions.beans.LoginBean;

/**
 * Service
 * @author guilhermeluizstolfo
 *
 */
public interface LoginServiceI {
	
	public List<LoginBean> getAll() throws IOException, AclFormatException;
	
}
