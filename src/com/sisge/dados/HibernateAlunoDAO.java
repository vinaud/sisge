package com.sisge.dados;

import com.sisge.negocio.entidades.Aluno;

public class HibernateAlunoDAO extends AbstractHibernateDAO<Aluno>{
	
	private static HibernateAlunoDAO unicaInstancia;
	
	private HibernateAlunoDAO(){
		
		
		
	}
	
	
	public static HibernateAlunoDAO getInstancia(){
		
		
		if(unicaInstancia!=null){
			
			return unicaInstancia;
		}else{
			
			unicaInstancia = new HibernateAlunoDAO();
			return unicaInstancia;
		}
		
	}
	

}
