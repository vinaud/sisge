package com.sisge.dados;

import java.sql.SQLException;

import com.sisge.negocio.entidades.Usuario;

public interface InterfaceAcessoDados {
	
	public void inserirUsuario(Usuario usuario) throws SQLException;

}
