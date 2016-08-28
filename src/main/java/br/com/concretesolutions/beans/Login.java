package br.com.concretesolutions.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Bean Login
 * @author guilhermeluizstolfo
 *
 */
@Entity
public class Login {
	
	@Id
    @Column(length = 250)
	private String id;
	
	@Column(length = 250)
	private String email;
	
	@Column(length = 250)
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		
}
