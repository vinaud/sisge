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
@Table(name="turmas")
public class Turma {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true,nullable=false)
	private String codigo;
	
	private int capacidade;
	
	@Column(nullable=false)
	private SituacaoTurma situacao;
	
	@OneToMany(mappedBy="turma")
	private List<Noticia> noticias;
	
	@OneToMany(mappedBy="turma")
	private List<Duvida> duvidas;
	
	@ManyToOne(targetEntity=Disciplina.class)
	private Disciplina disciplina;
	
	@ManyToOne(targetEntity=Professor.class)
	private Professor professor;
	
	@ManyToOne(targetEntity=Aluno.class)
	private List<Aluno> alunos;
	
	@OneToMany(mappedBy="turma")
	private List<Nota> notas;

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

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
	
	
	
	
	
	

}
