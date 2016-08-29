package br.com.concretesolutions.service;

import java.io.IOException;
import java.util.List;

import org.hsqldb.server.ServerAcl.AclFormatException;

import br.com.concretesolutions.beans.RegisterBean;

/**
 * Interface RegisterService
 * @author guilhermeluizstolfo
 *
 */
public interface RegisterServiceI {
	public String register(RegisterBean registerBean) throws IOException, AclFormatException;
	
	public List<RegisterBean> getAll() throws IOException, AclFormatException;
	
	public RegisterBean getById(String id) throws IOException, AclFormatException;
	
	public RegisterBean getByEmailAndPassword(String email, String password) throws IOException, AclFormatException;
	
	public RegisterBean getByEmail(String email) throws IOException, AclFormatException;
	
	public RegisterBean getByPassword(String password) throws IOException, AclFormatException;
}
