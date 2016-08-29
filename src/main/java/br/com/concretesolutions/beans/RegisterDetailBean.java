package br.com.concretesolutions.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * RegisterDetailBean
 * @author guilhermeluizstolfo
 *
 */
@Entity
public class RegisterDetailBean {
	
	@Id
	@Column(length=10000)
	private String id;
	
	@Column
	private Date created;
	
	@Column
	private Date modified;
	
	@Column
	private Date last_login;
	
	@Column(length=10000)
	private String token;
	
	@Column
	private RegisterBean registerBean;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public RegisterBean getRegisterBean() {
		return registerBean;
	}
	public void setRegisterBean(RegisterBean registerBean) {
		this.registerBean = registerBean;
	}
	
	
}
