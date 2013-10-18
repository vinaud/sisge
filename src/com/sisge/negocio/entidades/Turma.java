package com.sisge.negocio.entidades;

import java.util.List;

public class Turma {
	
	private long id;
	
	private String codigo;
	
	private int capacidade;
	
	private SituacaoTurma situacao;
	
	private List<Noticia> noticias;
	
	private List<Duvida> duvidas;
	
	private Disciplina disciplina;
	
	private Professor professor;
	
	private List<Aluno> alunos;
	
	private List<Notas> notas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public SituacaoTurma getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoTurma situacao) {
		this.situacao = situacao;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public List<Duvida> getDuvidas() {
		return duvidas;
	}

	public void setDuvidas(List<Duvida> duvidas) {
		this.duvidas = duvidas;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Notas> getNotas() {
		return notas;
	}

	public void setNotas(List<Notas> notas) {
		this.notas = notas;
	}
	
	
	
	
	
	
	

}
