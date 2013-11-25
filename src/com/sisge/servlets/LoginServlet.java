package com.sisge.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sisge.negocio.Negocio;
import com.sisge.negocio.entidades.Usuario;

public class LoginServlet extends HttpServlet{
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		
		String usuario = (String) req.getAttribute("nomeUsuario");
		String senha = (String) req.getAttribute("senha");
		
		Negocio n = Negocio.getInstancia();
		
		
		
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		
		
	}

}
