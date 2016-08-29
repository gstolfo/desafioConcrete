package br.com.concretesolutions.dao;

import java.io.IOException;
import java.util.List;

import org.hsqldb.server.ServerAcl.AclFormatException;

import br.com.concretesolutions.beans.RegisterBean;

/**
 * RegisterDao
 * @author guilhermeluizstolfo
 *
 */
public interface RegisterDaoI {
	
	public static final String ERROR_EMAIL_EXISTS = "error_email_exists";
	public static final String SUCCESS = "success";
	
	public String register(RegisterBean registerBean) throws IOException, AclFormatException ;

	public List<RegisterBean> getAll() throws IOException, AclFormatException;
	
	public RegisterBean getById(String id) throws IOException, AclFormatException;
	
	public RegisterBean getByEmailAndPassword(String email, String password) throws IOException, AclFormatException;
	
	public RegisterBean getByEmail(String email) throws IOException, AclFormatException;
	
	public RegisterBean getByPassword(String password) throws IOException, AclFormatException;
	
	public RegisterBean getRegisterBean(RegisterBean registerBean) throws IOException, AclFormatException;
}
