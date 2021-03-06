package com.sisge.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.sisge.negocio.entidades.TipoVinculo;
import com.sisge.negocio.entidades.Turma;
import com.sisge.negocio.entidades.Usuario;
import com.sisge.negocio.entidades.Vinculo;
import com.sisge.negocio.exceptions.LoginIncorretoException;
import com.sisge.negocio.exceptions.ValidacaoException;
import com.sun.jersey.api.core.HttpContext;

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
	public Usuario login(String usuario, String senha,HttpServletRequest context) throws LoginIncorretoException {
		Login loginx = new Login();
		return loginx.login(usuario,senha,context);
	}

	@Override
	public void inserirVinculo(Vinculo vinculo) throws SQLException {
		
		GerenciaVinculos g = new GerenciaVinculos();
		g.cadastrarVinculo(vinculo);
		
	}

	@Override
	public List listarVinculosPorTipo(long idUsuario, TipoVinculo tipo) {
		
		GerenciaVinculos g = new GerenciaVinculos();
		List list = g.listarVinculosPorTipo(idUsuario, tipo);
		return list;
	}

	@Override
	public void cadastrarTurma(Turma turma) throws SQLException {
		GerenciaTurmas g = new GerenciaTurmas();
		g.cadastrarTurma(turma);
		
	}

}
