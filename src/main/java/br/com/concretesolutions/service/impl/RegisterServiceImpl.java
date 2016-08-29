package br.com.concretesolutions.service.impl;

import java.io.IOException;
import java.util.List;

import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.dao.RegisterDaoI;
import br.com.concretesolutions.service.RegisterServiceI;

@Service
public class RegisterServiceImpl implements RegisterServiceI {

	@Autowired
	private RegisterDaoI registerDao;
	
	@Override
	public String register(RegisterBean registerBean) throws IOException, AclFormatException {
		return registerDao.register(registerBean);
	}

	@Override
	public List<RegisterBean> getAll() throws IOException, AclFormatException {
		return registerDao.getAll();
	}

	@Override
	public RegisterBean getById(String id) throws IOException, AclFormatException {
		
		return registerDao.getById(id);
	}

	@Override
	public RegisterBean getByEmailAndPassword(String email, String password) throws IOException, AclFormatException {
		return registerDao.getByEmailAndPassword(email, password);
	}

	@Override
	public RegisterBean getByEmail(String email) throws IOException, AclFormatException {
		return registerDao.getByEmail(email);
	}

	@Override
	public RegisterBean getByPassword(String password) throws IOException, AclFormatException {
		return registerDao.getByPassword(password);
	}

}
