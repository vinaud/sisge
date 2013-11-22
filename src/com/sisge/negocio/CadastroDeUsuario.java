package com.sisge.negocio;

import java.sql.SQLException;

import com.sisge.dados.AcessoDados;
import com.sisge.dados.InterfaceAcessoDados;
import com.sisge.negocio.entidades.Usuario;
import com.sisge.negocio.exceptions.ValidacaoException;

public class CadastroDeUsuario {
	
	
	
	
	public void cadastrar(Usuario usuario) throws SQLException, ValidacaoException{
		
		if(!validarAtributos(usuario)){
			
			throw new ValidacaoException();
		}else{
			
			InterfaceAcessoDados acessoDados= AcessoDados.getInstancia();
			acessoDados.inserirUsuario(usuario);
			
		}
		
		
		
	}
	
	
	private boolean validarAtributos(Usuario usuario){
		
		if(usuario.getNome()==null || usuario.getNome()=="" || 
				usuario.getNome().length()<1){	
			return false;
		}
		if(usuario.getSenha()==null ||usuario.getSenha().length()<5){
			return false;
		}
		
		if(usuario.getDadosPessoais().getNome()==null ||
				usuario.getDadosPessoais().getNome()==""){
			return false;
		}
		
		return true;

	}

}
