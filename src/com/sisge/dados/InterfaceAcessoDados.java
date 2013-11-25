package com.sisge.dados;

import java.sql.SQLException;

import com.sisge.negocio.entidades.Aluno;
import com.sisge.negocio.entidades.Professor;
import com.sisge.negocio.entidades.Usuario;

public interface InterfaceAcessoDados {
	
	public void inserirUsuario(Usuario usuario) throws SQLException;
	
	public void inserirVinculoAluno(Aluno aluno) throws SQLException;
	
	public void inserirVinculoProfessor(Professor professor) throws SQLException;

}
