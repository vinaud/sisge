package com.sisge.dados;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	
	private static HibernateUtil instancia;
	private static Session session;
	
	
	private HibernateUtil(){
		
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			SessionFactory factory = conf.buildSessionFactory();
			Session session = factory.openSession();
			
		
		
		
	}
	
	
	public static Session  getSession(){
		
		if(session!=null){
			
			return session;
		}else{
			
			instancia = new HibernateUtil();
			return session;
		}
		
		
	}

}
