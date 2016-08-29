package br.com.concretesolutions.beans;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Bean Register
 * @author guilhermeluizstolfo
 *
 */
@Entity
public class RegisterBean {
	
	@Id
	@Column(length = 10000)
	private String id;
	
	@Column(length = 250)
	private String name;
	
	@Column(length = 250)
	private String email;
	
	@Column(length = 250)
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<PhonesBean> phones;
	
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
	public List<PhonesBean> getPhones() {
		return phones;
	}
	public void setPhones(List<PhonesBean> phones) {
		this.phones = phones;
	}
}
