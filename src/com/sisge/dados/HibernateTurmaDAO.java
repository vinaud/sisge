package com.sisge.dados;

import com.sisge.negocio.entidades.Turma;

public class HibernateTurmaDAO extends AbstractHibernateDAO<Turma> implements TurmaDAO {
	
	private static HibernateTurmaDAO instancia;
	
	
	private HibernateTurmaDAO(){
		
		
		
	}
	
	public static HibernateTurmaDAO getInstancia(){
		
		if(instancia!=null){
			
			return instancia;
		}else{
			
			instancia = new HibernateTurmaDAO();
			return instancia;
		}
	}
	
	

}
