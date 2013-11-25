package com.sisge.dados;

import com.sisge.negocio.entidades.Professor;

public class HibernateProfessorDAO extends AbstractHibernateDAO<Professor> {
	
	
	private static HibernateProfessorDAO instancia;
	
	
	private HibernateProfessorDAO(){
		
		
	}
	
	public static HibernateProfessorDAO getInstancia(){
		
		if(instancia!=null){
			
			return instancia;
		}else{
			
			instancia = new HibernateProfessorDAO();
			return instancia;
		}
	}

}
