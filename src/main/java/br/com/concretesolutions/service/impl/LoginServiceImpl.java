package br.com.concretesolutions.service.impl;

import java.io.IOException;
import java.util.List;

import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.concretesolutions.beans.LoginBean;
import br.com.concretesolutions.dao.LoginDaoI;
import br.com.concretesolutions.service.LoginServiceI;

/**
 * LoginService
 * @author guilhermeluizstolfo
 *
 */
@Service
public class LoginServiceImpl implements LoginServiceI {
	
	@Autowired
	LoginDaoI loginDao;
	
	@Override
	public List<LoginBean> getAll() throws IOException, AclFormatException {
		return loginDao.getAll();
	}

}
