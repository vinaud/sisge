package com.sisge.recursos;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sisge.negocio.Negocio;
import com.sisge.negocio.entidades.Usuario;
import com.sisge.negocio.exceptions.LoginIncorretoException;
import com.sisge.negocio.exceptions.ResourceException;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.core.HttpContext;

@Path("login")
public class LoginResource {
	
	@Context
	protected HttpServletRequest request;
	
	
	@GET
	@Path("usuario/{usr}/senha/{senha}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String login(@PathParam("usr")String usuario,
			@PathParam("senha") String senha){
		
		Negocio n = Negocio.getInstancia();
		Usuario u;
		try {
			u = n.login(usuario, senha,request);
			GsonBuilder builder = new GsonBuilder();
			builder.setExclusionStrategies(new ExclusionStrategy() {
				
				@Override
				public boolean shouldSkipField(FieldAttributes f) {
					// TODO Auto-generated method stub
					return (f.getName().equals("usuario"));
				}
				
				@Override
				public boolean shouldSkipClass(Class<?> arg0) {
					// TODO Auto-generated method stub
					return false;
				}
			});
			Gson gson = builder.create();
			return gson.toJson(u);
		} catch (LoginIncorretoException e) {
			// TODO Auto-generated catch block
			throw new ResourceException(Status.UNAUTHORIZED,"Login Incorreto Exception");
			
		}
		
		
	}

}
