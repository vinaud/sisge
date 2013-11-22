package com.sisge.dados;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.sisge.negocio.entidades.Usuario;

public class HibernateUsuarioDAO extends AbstractHibernateDAO<Usuario> implements UsuarioDAO{
	
	
	private static HibernateUsuarioDAO instanciaUnica;
	
	public HibernateUsuarioDAO(){
		
		this.classe = Usuario.class;
		
	}
	
	public static HibernateUsuarioDAO getInstancia(){
		
		if(instanciaUnica!=null){
			
			return instanciaUnica;
			
		}else{
			
			instanciaUnica = new HibernateUsuarioDAO();
			return instanciaUnica;
			
		}
		
	}

	@Override
	public Usuario obterPorNomeUsuario(String nomeUsuario) {
		
		Session session = HibernateUtil.getInstancia().getSession();
		Criteria c = session.createCriteria(Usuario.class);
		c.add(Restrictions.eq("nome", nomeUsuario));
		if(c.list().size()>0){
			
			return (Usuario) c.list().get(0);
		}
		
		
		return null;
	}
	
	

}
