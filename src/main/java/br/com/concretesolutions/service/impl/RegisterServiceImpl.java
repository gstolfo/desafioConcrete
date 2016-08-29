package br.com.concretesolutions.service.impl;

import java.io.IOException;

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

}
