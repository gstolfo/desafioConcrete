package br.com.concretesolutions.service;

import java.io.IOException;

import org.hsqldb.server.ServerAcl.AclFormatException;

import br.com.concretesolutions.beans.RegisterBean;

/**
 * Interface RegisterService
 * @author guilhermeluizstolfo
 *
 */
public interface RegisterServiceI {
	public String register(RegisterBean registerBean) throws IOException, AclFormatException;
}
