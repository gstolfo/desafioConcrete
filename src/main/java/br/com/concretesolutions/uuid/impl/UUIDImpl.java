package br.com.concretesolutions.uuid.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.concretesolutions.uuid.UUIDI;

/**
 * Class UUID generate
 * @author guilhermeluizstolfo
 *
 */
@Service
public class UUIDImpl implements UUIDI{
	
	public String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString(); 
	}
	
}
