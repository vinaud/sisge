package com.sisge.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="duvidas")
public class Duvida {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String pergunta;
	
	private String resposta;
	
	private boolean publica;
	
	@ManyToOne(targetEntity=Aluno.class)
	private Aluno enviadaPor;
	
	@ManyToOne(targetEntity=Turma.class)
	private Turma turma;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public boolean isPublica() {
		return publica;
	}

	public void setPublica(boolean publica) {
		this.publica = publica;
	}

	public Aluno getEnviadaPor() {
		return enviadaPor;
	}

	public void setEnviadaPor(Aluno enviadaPor) {
		this.enviadaPor = enviadaPor;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
	
	

}
