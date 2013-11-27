package com.sisge.dados;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sisge.negocio.entidades.Professor;

public class HibernateProfessorDAO extends AbstractHibernateDAO<Professor> implements ProfessorDAO{
	
	
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

	@Override
	public List listar(long idUsuario) {
		
		Session session  = HibernateUtil.getInstancia().getSession();
		Criteria c = session.createCriteria(Professor.class);
		c.add(Restrictions.eq("usuario.id", idUsuario));
		
		return c.list();
	}

}
