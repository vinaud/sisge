package com.sisge.negocio.entidades;

public class Notas {
	
	private long id;
	
	private double[] notasParciais;
	
	private double notaRecuperacao;
	
	private double notaFinal;

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
	
	
	
		

}
