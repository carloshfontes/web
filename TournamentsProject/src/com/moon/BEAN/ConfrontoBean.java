package com.moon.BEAN;

import java.util.Date;

public class ConfrontoBean {
	
	private int numero_confronto;
	private int id;
	private int id_rodada;
	private int id_equipe1;
	private int id_equipe2;
	private int id_campeao;
	private int id_campeonato;
	
	
	public ConfrontoBean(int numero_confronto, int id, int id_rodada, int id_equipe1, int id_equipe2, int id_campeao, int id_campeonato) {
		super();
		this.setNumero_confronto(numero_confronto);
		this.setId(id);
		this.setId_rodada(id_rodada);
		this.setId_equipe1(id_equipe1);
		this.setId_equipe2(id_equipe2);
		this.setId_campeao(id_campeao);
		this.setId_campeonato(id_campeonato);
	}
	
	public ConfrontoBean(int numero_confronto, int id, int id_rodada, int id_equipe1, int id_campeao, int id_campeonato) {
		super();
		this.setNumero_confronto(numero_confronto);
		this.setId(id);
		this.setId_rodada(id_rodada);
		this.setId_equipe1(id_equipe1);
		this.setId_campeao(id_campeao);
		this.setId_campeonato(id_campeonato);
	}
	
	public ConfrontoBean(int numero_confronto, int id, int id_rodada, int id_equipe1, int id_campeonato) {
		super();
		this.setNumero_confronto(numero_confronto);
		this.setId(id);
		this.setId_rodada(id_rodada);
		this.setId_equipe1(id_equipe1);
		this.setId_campeonato(id_campeonato);
	}
	
	public int getNumero_confronto() {
		return numero_confronto;
	}
	public void setNumero_confronto(int numero_confronto) {
		this.numero_confronto = numero_confronto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_rodada() {
		return id_rodada;
	}
	public void setId_rodada(int id_rodada) {
		this.id_rodada = id_rodada;
	}
	public int getId_equipe1() {
		return id_equipe1;
	}
	public void setId_equipe1(int id_equipe1) {
		this.id_equipe1 = id_equipe1;
	}
	public int getId_equipe2() {
		return id_equipe2;
	}
	public void setId_equipe2(int id_equipe2) {
		this.id_equipe2 = id_equipe2;
	}
	public int getId_campeao() {
		return id_campeao;
	}
	public void setId_campeao(int id_campeao) {
		this.id_campeao = id_campeao;
	}
	public int getId_campeonato() {
		return id_campeonato;
	}
	public void setId_campeonato(int id_campeonato) {
		this.id_campeonato = id_campeonato;
	}

	
}
