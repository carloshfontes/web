package com.moon.BEAN;

import java.util.Date;

public class RodadaBean {
	
	private int id;
	private int numero;
	private Date data;
	
	public RodadaBean(int numero, int id, Date data) {
		super();
		this.setNumero(numero);
		this.setId(id);
		this.setData(data);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
