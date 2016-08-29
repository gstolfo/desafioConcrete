package br.com.concretesolutions.service.impl;

import java.io.IOException;

import org.hsqldb.server.ServerAcl.AclFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.concretesolutions.beans.RegisterBean;
import br.com.concretesolutions.beans.RegisterDetailBean;
import br.com.concretesolutions.dao.RegisterDetailDaoI;
import br.com.concretesolutions.service.RegisterDetailServiceI;

/**
 * Service RegisterDetail
 * @author guilhermeluizstolfo
 *
 */
@Service
public class RegisterDetailServiceImpl implements RegisterDetailServiceI {

	@Autowired
	private RegisterDetailDaoI registerDetailDao;

	@Override
	public RegisterDetailBean getRegisterDetailBean(RegisterBean registerBean, RegisterDetailBean registerDetailBean)
			throws IOException, AclFormatException {
		
		return registerDetailDao.getRegisterDetailBean(registerBean, registerDetailBean);
	}
	

}
