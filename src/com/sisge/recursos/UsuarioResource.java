package com.sisge.recursos;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sisge.negocio.InterfaceNegocio;
import com.sisge.negocio.Negocio;
import com.sisge.negocio.entidades.Usuario;
import com.sisge.negocio.exceptions.ResourceException;
import com.sisge.negocio.exceptions.ValidacaoException;
import com.sun.jersey.api.client.ClientResponse.Status;

@Path("usuario")
public class UsuarioResource {
	
	@Context
	protected HttpServletRequest context;

	@Path("logado")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String obterUsuarioLogado(){
		
		//InterfaceNegocio n = Negocio.getInstancia();
		
		Usuario usuario = (Usuario) context.getSession(false).getAttribute("usuario");
		if(usuario==null){
			
			throw new ResourceException(Status.FORBIDDEN, "ACESSO NEGADO");
			
		}
		
		GsonBuilder builder = new GsonBuilder();
		
		builder.setExclusionStrategies(new ExclusionStrategy() {
			
			@Override
			public boolean shouldSkipField(FieldAttributes f) {
				// TODO Auto-generated method stub
				return (f.getName()).equals("usuario");
			}
			@Override
			public boolean shouldSkipClass(Class<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		
		Gson gson = builder.create();
		
		return gson.toJson(usuario);
		
	}
	
	
	
	@Path("novo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrar(String usuario) throws ResourceException{
		
		GsonBuilder builder= new GsonBuilder();
		builder.setDateFormat("yyyy-mm-dd");
		Gson gson = builder.create();
		Usuario usr = (Usuario)gson.fromJson(usuario, Usuario.class);
		
		Negocio n = Negocio.getInstancia();
		try {
			n.cadastrarUsuario(usr);
		} catch (SQLException e) {
			throw new ResourceException(Status.UNAUTHORIZED, "Erro do banco");
			
		} catch (ValidacaoException e) {
			// TODO Auto-generated catch block
			throw new ResourceException(Status.UNAUTHORIZED,"Erro de Validacao");
		}
		
	}
	
	
	


}
