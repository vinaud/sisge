package com.sisge.dados;

import java.sql.SQLException;
import java.util.List;

import com.sisge.negocio.entidades.Aluno;
import com.sisge.negocio.entidades.Professor;
import com.sisge.negocio.entidades.TipoVinculo;
import com.sisge.negocio.entidades.Turma;
import com.sisge.negocio.entidades.Usuario;

public interface InterfaceAcessoDados {
	
	public void inserirUsuario(Usuario usuario) throws SQLException;
	
	public void inserirVinculoAluno(Aluno aluno) throws SQLException;
	
	public void inserirVinculoProfessor(Professor professor) throws SQLException;
	
	public List listarVinculosAluno(long idUsuario);
	
	public List listarVinculosProfessor(long idUsuario);
	
	public void inserirTurma(Turma turma) throws SQLException;

}
