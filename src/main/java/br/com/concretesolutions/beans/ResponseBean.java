package br.com.concretesolutions.beans;

import org.springframework.http.HttpStatus;

public class ResponseBean<T> {
	/*
	public ResponseBean(HttpHeaders httpHeaders, HttpStatus httpStatus){
		this.httpHeaders = httpHeaders;
		this.httpStatus = httpStatus;
	}
	*/
	public ResponseBean(String mensagem, HttpStatus httpStatus, int codHttpStatus){
		this.mensagem = mensagem;
		this.httpStatus = httpStatus;
		this.codHttpStatus = codHttpStatus;
	}
	
	//private HttpHeaders httpHeaders;
	private HttpStatus httpStatus;
	private String mensagem;
	private int codHttpStatus; 
	
	/*public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}
	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}*/
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
	
}
