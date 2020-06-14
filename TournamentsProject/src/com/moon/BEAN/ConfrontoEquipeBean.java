package com.moon.BEAN;

public class ConfrontoEquipeBean {
	
	private int numero_confronto;
	private int id;
	private int id_rodada;
	private int id_equipe1;
	private int id_equipe2;
	private int id_campeao;
	private int id_campeonato;
	private String equipe1;
	private String equipe2;
	
	
	
	public ConfrontoEquipeBean(int numero_confronto, int id, int id_rodada, int id_equipe1, int id_equipe2,
			int id_campeao, int id_campeonato, String equipe1, String equipe2) {
		super();
		this.numero_confronto = numero_confronto;
		this.id = id;
		this.id_rodada = id_rodada;
		this.id_equipe1 = id_equipe1;
		this.id_equipe2 = id_equipe2;
		this.id_campeao = id_campeao;
		this.id_campeonato = id_campeonato;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
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
	public String getEquipe1() {
		return equipe1;
	}
	public void setEquipe1(String equipe1) {
		this.equipe1 = equipe1;
	}
	public String getEquipe2() {
		return equipe2;
	}
	public void setEquipe2(String equipe2) {
		this.equipe2 = equipe2;
	}
	
	
	

}
