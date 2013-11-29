package com.sisge.dados;

import java.sql.SQLException;
import java.util.List;

import com.sisge.negocio.entidades.Aluno;
import com.sisge.negocio.entidades.Professor;
import com.sisge.negocio.entidades.TipoVinculo;
import com.sisge.negocio.entidades.Turma;
import com.sisge.negocio.entidades.Usuario;

public class AcessoDados implements InterfaceAcessoDados {
	
	private static AcessoDados instanciaUnica;
	
	
	private AcessoDados(){
		
		
	}

	@Override
	public void inserirUsuario(Usuario usuario) throws SQLException{
		
		HibernateUsuarioDAO dao = HibernateUsuarioDAO.getInstancia();
		dao.inserir(usuario);
		

	}
	
	
	
	public static AcessoDados  getInstancia(){
		
		if(instanciaUnica!= null){
			
			return instanciaUnica;
		}else{
			
			instanciaUnica= new AcessoDados();
			return instanciaUnica;
		}
		
	}

	@Override
	public void inserirVinculoAluno(Aluno aluno) throws SQLException {
		
		HibernateAlunoDAO dao = HibernateAlunoDAO.getInstancia();
		dao.inserir(aluno);
		
	}

	@Override
	public void inserirVinculoProfessor(Professor professor)
			throws SQLException {
		
		HibernateProfessorDAO dao = HibernateProfessorDAO.getInstancia();
		dao.inserir(professor);
		
	}

	@Override
	public List listarVinculosAluno(long idUsuario) {
		
		AlunoDAO dao =HibernateAlunoDAO.getInstancia();
		List lista = dao.listar(idUsuario);
		
		return lista;
	}

	@Override
	public List listarVinculosProfessor(long idUsuario) {
		
		ProfessorDAO dao = HibernateProfessorDAO.getInstancia();
		List lista = dao.listar(idUsuario);
		
		return lista;
	}

	@Override
	public void inserirTurma(Turma turma) throws SQLException {
		
		HibernateTurmaDAO dao = HibernateTurmaDAO.getInstancia();
		dao.inserir(turma);
		
	}

}
