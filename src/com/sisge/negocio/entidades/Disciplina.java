package com.sisge.negocio.entidades;

import java.util.List;

public class Disciplina {
	
	private long id;
	
	private String nome;
	
	private List<Turma> turmas;
	
	private Professor cadastradaPor;

	public long getId() {
		return id;
	}
	
	

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public List<Turma> getTurmas() {
		return turmas;
	}



	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}



	public Professor getCadastradaPor() {
		return cadastradaPor;
	}



	public void setCadastradaPor(Professor cadastradaPor) {
		this.cadastradaPor = cadastradaPor;
	}
	
	
	
	

}
