package com.sisge.negocio.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="disciplinas")
public class Disciplina {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String nome;
	
	@OneToMany(mappedBy="disciplina")
	private List<Turma> turmas;
	
	@ManyToOne(targetEntity=Professor.class)
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
