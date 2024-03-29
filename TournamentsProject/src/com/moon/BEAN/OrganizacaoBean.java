package com.moon.BEAN;

public class OrganizacaoBean {
	
	private String nome;
	private int id;
	private String usuario;
	private String senha;
	
	public OrganizacaoBean(String nome, int id, String usuario, String senha) {
		super();
		this.setNome(nome);
		this.setId(id);
		this.setUsuario(usuario);
		this.setSenha(senha);
	}
	
	public OrganizacaoBean(int id) {
		super();
		this.setId(id);
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
