package com.sisge.negocio;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import com.sisge.negocio.entidades.Usuario;
import com.sisge.negocio.exceptions.ValidacaoException;

public interface InterfaceNegocio {
	
	public void cadastrarUsuario(Usuario usuario) throws SQLException, ValidacaoException;
	
	public Usuario login(String usuario, String senha,HttpServlet context);

}
