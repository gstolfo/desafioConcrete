package br.com.concretesolutions.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class Register
 * @author guilhermeluizstolfo
 *
 */
@Entity
public class Register {
	
	@Id
	@Column
	private String id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private Phones phones;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Phones getPhones() {
		return phones;
	}
	public void setPhones(Phones phones) {
		this.phones = phones;
	}
	
	
	
}
