package com.sisge.negocio;

import java.sql.SQLException;

import com.sisge.dados.AcessoDados;
import com.sisge.negocio.entidades.SituacaoTurma;
import com.sisge.negocio.entidades.Turma;

public class GerenciaTurmas {
	
	public void cadastrarTurma(Turma turma) throws SQLException{
		
		AcessoDados acesso = AcessoDados.getInstancia();
		turma.setSituacao(SituacaoTurma.ABERTA);
		acesso.inserirTurma(turma);
		
	}

}
