package com.sisge.negocio.entidades;

public class Duvida {
	
	private long id;
	
	private String pergunta;
	
	private String resposta;
	
	private boolean publica;
	
	private Aluno enviadaPor;
	
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
