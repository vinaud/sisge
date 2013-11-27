package com.sisge.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sisge.negocio.entidades.TipoVinculo;
import com.sisge.negocio.entidades.Usuario;
import com.sisge.negocio.entidades.Vinculo;
import com.sisge.negocio.exceptions.LoginIncorretoException;
import com.sisge.negocio.exceptions.ValidacaoException;

public interface InterfaceNegocio {
	
	public void cadastrarUsuario(Usuario usuario) 
			throws SQLException, ValidacaoException;
	
	public Usuario login(String usuario, String senha,HttpServletRequest context)
			throws LoginIncorretoException;
	
	
	public void inserirVinculo(Vinculo vinculo) throws SQLException;
	
	
	public List listarVinculosPorTipo(long idUsuario, TipoVinculo tipo);

}
