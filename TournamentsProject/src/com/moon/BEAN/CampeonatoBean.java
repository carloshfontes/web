package com.moon.BEAN;

import java.util.Date;

public class CampeonatoBean {
	
	private String nome;
	private int id;
	private String jogo;
	private String descricao;
	private Date data;
	private int max_equipes;

	public CampeonatoBean(String nome, int id, String jogo, String descricao, Date data, int max_equipes) {
		super();
		this.setNome(nome);
		this.setId(id);
		this.setJogo(jogo);
		this.setDescricao(descricao);
		this.setData(data);
		this.setMax_equipes(max_equipes);
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
	public String getJogo() {
		return jogo;
	}
	public void setJogo(String jogo) {
		this.jogo = jogo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getMax_equipes() {
		return max_equipes;
	}
	public void setMax_equipes(int max_equipes) {
		this.max_equipes = max_equipes;
	}
}
