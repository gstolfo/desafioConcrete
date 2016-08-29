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
	
	public LoginBean getById(String id) throws IOException, AclFormatException;
	
	public LoginBean getByEmailAndPassword(String email, String password) throws IOException, AclFormatException;
	
	public LoginBean getByEmail(String email) throws IOException, AclFormatException;
	
	public LoginBean getByPassword(String password) throws IOException, AclFormatException;
}
