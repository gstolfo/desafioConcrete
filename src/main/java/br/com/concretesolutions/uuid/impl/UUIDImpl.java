package br.com.concretesolutions.uuid.impl;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.concretesolutions.uuid.IUUID;

/**
 * Class UUID generate
 * @author guilhermeluizstolfo
 *
 */
@Repository
public class UUIDImpl implements IUUID{
	
	public String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString(); 
	}
	
}
