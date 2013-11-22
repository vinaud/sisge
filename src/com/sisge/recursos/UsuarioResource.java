package com.sisge.recursos;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sisge.negocio.Negocio;
import com.sisge.negocio.entidades.Usuario;
import com.sisge.negocio.exceptions.ValidacaoException;

@Path("usuario")
public class UsuarioResource {
	

	
	
	@Path("novo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrar(String usuario) throws SQLException, ValidacaoException{
		
		GsonBuilder builder= new GsonBuilder();
		builder.setDateFormat("yyyy-mm-dd");
		Gson gson = builder.create();
		Usuario usr = (Usuario)gson.fromJson(usuario, Usuario.class);
		
		Negocio n = Negocio.getInstancia();
		n.cadastrarUsuario(usr);
		
	}
	
	
	


}
