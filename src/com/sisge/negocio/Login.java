package com.sisge.negocio;

import javax.servlet.http.HttpServlet;

import com.sisge.dados.HibernateUsuarioDAO;
import com.sisge.negocio.entidades.Usuario;

public class Login {
	
	
	
	public Usuario login(String usuario, String senha,HttpServlet context){
		
		
		
		Usuario usr = HibernateUsuarioDAO.getInstancia().obterPorNomeUsuario(usuario);
		
		
		return usr;
		
	}

}
