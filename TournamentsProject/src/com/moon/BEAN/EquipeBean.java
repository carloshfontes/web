package com.moon.BEAN;

public class EquipeBean {
	
	private String nome;
	private int id;
	private String usuario;
	private String senha;
	
	public EquipeBean(String nome, int id, String usuario, String senha) {
		super();
		this.setNome(nome);
		this.setId(id);
		this.setUsuario(usuario);
		this.setSenha(senha);
	}
	
	public EquipeBean(int id) {
		super();
		this.setId(id);
	}
	
	public EquipeBean(int id, String nome) {
		super();
		this.setId(id);
		this.setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
