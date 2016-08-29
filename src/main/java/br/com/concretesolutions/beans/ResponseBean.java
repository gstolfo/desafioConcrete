package br.com.concretesolutions.beans;

import org.springframework.http.HttpStatus;

public class ResponseBean<T> {
	
	public ResponseBean(String mensagem, HttpStatus httpStatus, int codHttpStatus){
		this.mensagem = mensagem;
		this.httpStatus = httpStatus;
		this.codHttpStatus = codHttpStatus;
	}
	
	public ResponseBean(String mensagem, HttpStatus httpStatus, int codHttpStatus, String token){
		this.mensagem = mensagem;
		this.httpStatus = httpStatus;
		this.codHttpStatus = codHttpStatus;
		this.token = token;
	}
	
	
	private HttpStatus httpStatus;
	private String mensagem;
	private int codHttpStatus;
	private String token;
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public int getCodHttpStatus() {
		return codHttpStatus;
	}
	public void setCodHttpStatus(int codHttpStatus) {
		this.codHttpStatus = codHttpStatus;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
