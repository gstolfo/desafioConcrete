package br.com.concretesolutions.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
