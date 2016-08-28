package br.com.conretesolutions.database.hibernate;

import java.io.IOException;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl.AclFormatException;

public class StartHsqldb {

	/**
	 * Start HSQLDB
	 * @throws AclFormatException 
	 * @throws IOException 
	 */
	public void startHsqldb() throws IOException, AclFormatException{
        System.out.println("Starting Database");
        HsqlProperties p = new HsqlProperties();
        p.setProperty("server.database.0", "sss");
        p.setProperty("server.dbname.0", "sss");
        p.setProperty("server.port", "9001");
        Server server = new Server();
        server.setProperties(p);
        server.setLogWriter(null); 
        server.setErrWriter(null); 
        server.start();	    
	}
}
