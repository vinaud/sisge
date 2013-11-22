package com.sisge.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="notas")
public class Nota {
	@Id
	@GeneratedValue
	private long id;
	
	
	private double[] notasParciais;
	
	private double notaRecuperacao;
	
	private double notaFinal;
	
	@ManyToOne(targetEntity=Aluno.class)
	private Aluno aluno;
	
	@ManyToOne(targetEntity=Turma.class)
	private Turma turma;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double[] getNotasParciais() {
		return notasParciais;
	}

	public void setNotasParciais(double[] notasParciais) {
		this.notasParciais = notasParciais;
	}

	public double getNotaRecuperacao() {
		return notaRecuperacao;
	}

	public void setNotaRecuperacao(double notaRecuperacao) {
		this.notaRecuperacao = notaRecuperacao;
	}

	public double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
	
	
	
		

}
