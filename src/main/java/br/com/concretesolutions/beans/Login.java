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
    @Column
	private Integer id;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
