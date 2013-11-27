package com.sisge.dados;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sisge.negocio.entidades.Aluno;
import com.sisge.negocio.entidades.Professor;
import com.sisge.negocio.entidades.TipoVinculo;
import com.sisge.negocio.entidades.Vinculo;

public class HibernateAlunoDAO extends AbstractHibernateDAO<Aluno> implements AlunoDAO{
	
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


	@Override
	public List listar(long idUsuario) {
		
		Session session = HibernateUtil.getInstancia().getSession();
		Criteria  c = session.createCriteria(Aluno.class);
		
		c.add(Restrictions.eq("usuario.id",idUsuario));
		
		
		
		return c.list();
	}
	
	
	

}
