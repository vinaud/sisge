package com.sisge.dados;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractHibernateDAO<T> implements AbstractDAO<T>{
	
	
	protected Class<?> classe;
	
	

	@Override
	public void inserir(T entidade) throws SQLException {
		
		Session session = HibernateUtil.getInstancia().getSession();
		Transaction tx = session.beginTransaction();
		session.save(entidade);
		tx.commit();
		session.close();
		
		
	}

	@Override
	public T obter(long id) {
		
		Session session = HibernateUtil.getInstancia().getSession();
		Transaction tx = session.beginTransaction();
		T entidade = (T)session.get(classe,id);
		return entidade;
		
	}

	@Override
	public void atualizar(T entidade) {
		Session session = HibernateUtil.getInstancia().getSession();
		Transaction tx = session.beginTransaction();
		session.update(entidade);
		
	}

	@Override
	public void remover(long id) {
		
	/*	Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.createQuery("delete from "+class.getClass().getSimpleName()); */
		
		
	}

	@Override
	public List<T> listarTodos() {
		
		Session session = HibernateUtil.getInstancia().getSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(classe);
		List<T> lista = (List<T>) c.list();
		return lista;
		
		
	}

}
