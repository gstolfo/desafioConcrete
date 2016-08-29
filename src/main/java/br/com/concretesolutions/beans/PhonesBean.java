package br.com.concretesolutions.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.FetchMode;

/**
 * Bean Phones
 * @author guilhermeluizstolfo
 */
@Entity
public class PhonesBean {
	
	@Id
	@Column(length = 1000)
	private String id;
	
	@Column(length=3)
	private Integer ddd;
	
	@Column(length=9)
	private String number;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private RegisterBean registerBean;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
		
}
