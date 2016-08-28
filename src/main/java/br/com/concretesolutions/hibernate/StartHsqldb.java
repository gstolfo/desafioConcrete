package br.com.concretesolutions.hibernate;

import java.io.IOException;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerProperties;
import org.hsqldb.server.ServerAcl.AclFormatException;

/**
 * StartHsqldb
 * @author guilhermeluizstolfo
 *
 */
public class StartHsqldb {

	private static StartHsqldb instance = null;
	
	public void startHsqldb() throws IOException, AclFormatException{
		
		System.out.println("Starting Database");
        HsqlProperties p = new HsqlProperties();
        p.setProperty("server.database.0", "sss");
        p.setProperty("server.dbname.0", "sss");
        p.setProperty("server.port", "9001");
        Server server = new Server();
		//if(server.getState() != 1){
        	server.getStateDescriptor();
        	server.getState();
        	server.getServerId();
	        server.setProperties(p);
	        server.setLogWriter(null); 
	        server.setErrWriter(null); 
	        server.start();	 
		//}
		
	}
	
	public static StartHsqldb getInstance(){
		if(instance == null){
			instance = new StartHsqldb();
		}
		return instance;
	}
}
