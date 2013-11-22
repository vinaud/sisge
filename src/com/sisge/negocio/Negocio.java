package com.sisge.negocio;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import com.sisge.negocio.entidades.Usuario;
import com.sisge.negocio.exceptions.ValidacaoException;

public class Negocio implements InterfaceNegocio{

	private static Negocio instanciaUnica;
	
	private Negocio(){
		
		
	}
	
	public static Negocio getInstancia(){
		
		if(instanciaUnica!=null){
			
			return instanciaUnica;
		}else{
			
			instanciaUnica = new Negocio();
			return instanciaUnica;
		}
	}
	
	@Override
	public void cadastrarUsuario(Usuario usuario) throws SQLException, ValidacaoException{
		
		CadastroDeUsuario cad = new CadastroDeUsuario();
		cad.cadastrar(usuario) ;
		
	}

	@Override
	public Usuario login(String usuario, String senha,HttpServlet context) {
		Login loginx = new Login();
		return loginx.login(usuario,senha,context);
	}

}
