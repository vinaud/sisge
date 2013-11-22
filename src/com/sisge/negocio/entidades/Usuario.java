package com.sisge.negocio.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;





@Entity
@Table(name="usuarios")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="nome",unique=true, nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String senha;
	
	@OneToMany(mappedBy="usuario")
	
	@Cascade(CascadeType.ALL)
	private List<Vinculo> vinculos;
	
	
	@OneToOne(targetEntity=DadosPessoais.class)
	@Cascade(CascadeType.ALL)
	private DadosPessoais dadosPessoais;
	
	public Usuario(){
		
		
	}

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Vinculo> getVinculos() {
		return vinculos;
	}

	public void setVinculos(List<Vinculo> vinculos) {
		this.vinculos = vinculos;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}
	
	
	
	

}
