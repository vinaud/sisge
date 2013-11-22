package com.sisge.recursos;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sisge.negocio.Negocio;
import com.sisge.negocio.entidades.Usuario;

@Path("login")
public class LoginResource {
	
	//@Context
	//protected HttpServlet context;
	
	
	@GET
	@Path("usuario/{usr}/senha/{senha}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String login(@PathParam("usr")String usuario,@PathParam("senha") String senha){
		
		Negocio n = Negocio.getInstancia();
		Usuario u =  n.login(usuario, senha,null);
		Gson gson = new Gson();
		return gson.toJson(u);
		
	}

}
