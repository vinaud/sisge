package com.sisge.negocio;

import java.sql.SQLException;

import com.sisge.dados.AcessoDados;
import com.sisge.negocio.entidades.Aluno;
import com.sisge.negocio.entidades.Professor;
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

}
