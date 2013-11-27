package com.sisge.negocio;

import java.sql.SQLException;
import java.util.List;

import com.sisge.dados.AcessoDados;
import com.sisge.negocio.entidades.Aluno;
import com.sisge.negocio.entidades.Professor;
import com.sisge.negocio.entidades.TipoVinculo;
import com.sisge.negocio.entidades.Vinculo;

public class GerenciaVinculos {
	
	
	public void cadastrarVinculo(Vinculo vinculo) throws SQLException{
		
		if(vinculo.getClass()==Aluno.class){
			AcessoDados acesso = AcessoDados.getInstancia();
			acesso.inserirVinculoAluno((Aluno)vinculo);
		}else{
			
			AcessoDados acesso = AcessoDados.getInstancia();
			acesso.inserirVinculoProfessor((Professor) vinculo);
		}
		
		
		
	}
	
	public List listarVinculosPorTipo(long idUsuario,TipoVinculo tipo){
		
		if(tipo==TipoVinculo.ALUNO){
			
			return AcessoDados.getInstancia().listarVinculosAluno(idUsuario);
			
			
		}else{
			return AcessoDados.getInstancia().listarVinculosProfessor(idUsuario);
			
			
		}
		
	}

}
