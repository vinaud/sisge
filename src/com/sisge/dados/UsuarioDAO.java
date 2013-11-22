package com.sisge.dados;

import com.sisge.negocio.entidades.Usuario;

public interface UsuarioDAO {
	
	public Usuario obterPorNomeUsuario(String nomeUsuario);

}
