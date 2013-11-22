package com.sisge.dados;

import java.sql.SQLException;

import com.sisge.negocio.entidades.Usuario;

public class AcessoDados implements InterfaceAcessoDados {
	
	private static AcessoDados instanciaUnica;
	
	
	private AcessoDados(){
		
		
	}

	@Override
	public void inserirUsuario(Usuario usuario) throws SQLException{
		
		HibernateUsuarioDAO dao = HibernateUsuarioDAO.getInstancia();
		dao.inserir(usuario);
		

	}
	
	
	
	public static AcessoDados  getInstancia(){
		
		if(instanciaUnica!= null){
			
			return instanciaUnica;
		}else{
			
			instanciaUnica= new AcessoDados();
			return instanciaUnica;
		}
		
	}

}
