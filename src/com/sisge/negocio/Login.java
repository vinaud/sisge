package com.sisge.negocio;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.sisge.dados.HibernateUsuarioDAO;
import com.sisge.negocio.entidades.Usuario;
import com.sisge.negocio.exceptions.LoginIncorretoException;
import com.sun.jersey.api.core.HttpContext;

public class Login {
	
	
	
	public Usuario login(String usuario, String senha,HttpServletRequest request)
			throws LoginIncorretoException{
		
		
		Usuario usr = HibernateUsuarioDAO.getInstancia().obterPorNomeUsuario(usuario);
		
		if(usr==null || !(usr.getSenha().equals(senha))){
			throw new LoginIncorretoException();
		}
		
		request.getSession(true).setAttribute("usuario", usr);
		return usr;
		
	}
	
	
	public void logout(HttpServletRequest request){
		
		request.getSession().invalidate();
		
	}

}
