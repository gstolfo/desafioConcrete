package br.com.concretesolutions.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Bean Phones
 * @author guilhermeluizstolfo
 */
@Entity
public class PhonesBean {
	
	@Id
	private Integer id;
	
	@Column
	private Integer ddd;
	
	@Column
	private String number;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
