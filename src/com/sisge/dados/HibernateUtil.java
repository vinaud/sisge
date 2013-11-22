package com.sisge.dados;

import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	
	private static HibernateUtil unicaInstancia;
	private Configuration conf;
	private SessionFactory sessionFactory;
	private Session session;
	
	private HibernateUtil(){
		
			conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			sessionFactory = conf.buildSessionFactory();
			
			
		
		
		
	}
	
	
	public static HibernateUtil  getInstancia(){
		
		if(unicaInstancia!=null){

			return unicaInstancia;
		}else{
			
			unicaInstancia = new HibernateUtil();
			return unicaInstancia;
		}
		
		
	}
	
	public Session getSession(){
		
		if(this.session!=null && this.session.isOpen()){
			
			return session;
		}else{
			
			session = sessionFactory.openSession();
			return session;
			
		}
		
		
		
	}

}
