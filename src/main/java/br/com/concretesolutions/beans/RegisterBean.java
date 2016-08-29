package br.com.concretesolutions.beans;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Bean Register
 * @author guilhermeluizstolfo
 *
 */
@Entity
public class RegisterBean {
	
	@Id
	@Column
	private String id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private PhonesBean phones;
	
	
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PhonesBean getPhones() {
		return phones;
	}
	public void setPhones(PhonesBean phones) {
		this.phones = phones;
	}
	
	
	
}
