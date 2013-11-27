package com.sisge.recursos;

import java.sql.SQLException;
import java.util.List;

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
import com.sisge.negocio.entidades.Aluno;
import com.sisge.negocio.entidades.Professor;
import com.sisge.negocio.entidades.TipoVinculo;
import com.sisge.negocio.entidades.Usuario;
import com.sisge.negocio.exceptions.ResourceException;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.research.ws.wadl.Application;


@Path("vinculos")
public class VinculoResource {
	
	@Context
	protected HttpServletRequest request;
	
	@Path("aluno")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvarVinculoAluno(String vinculo){
		
		
		Gson gson = new Gson();
		Aluno aluno = gson.fromJson(vinculo, Aluno.class);
		InterfaceNegocio i = Negocio.getInstancia();
		try {
			i.inserirVinculo(aluno);
			
		} catch (SQLException e) {
			throw new ResourceException(Status.NOT_FOUND, "não foi possível cadastrar o vínculo");
		}
		
		
		
		
	}
	
	@Path("professor")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvarVinculoProfessor(String vinculo){
		
		
		Gson gson = new Gson();
		Professor professor = gson.fromJson(vinculo, Professor.class);
		InterfaceNegocio i = Negocio.getInstancia();
		try {
			i.inserirVinculo(professor);
			
		} catch (SQLException e) {
			throw new ResourceException(Status.NOT_FOUND, "não foi possível cadastrar o vínculo");
		}
	}
	
	@Path("/lista/tipo/{tipo}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarProfessor(@PathParam("tipo")String tipoVinculo){
		
		Usuario usr = (Usuario) request.getSession().getAttribute("usuario");
		if(usr==null){
			
			throw new ResourceException(Status.FORBIDDEN, "Recurso Negado");
		}
		long idUsuario = usr.getId();
		
		Negocio n = Negocio.getInstancia();
		List l=null;
		if(tipoVinculo.equalsIgnoreCase("ALUNO")){
			
			l = n.listarVinculosPorTipo(idUsuario, TipoVinculo.ALUNO);
		}else if(tipoVinculo.equalsIgnoreCase(tipoVinculo)){
			
			l = n.listarVinculosPorTipo(idUsuario, TipoVinculo.PROFESSOR);
		}else{
			
			throw new ResourceException(Status.BAD_REQUEST,"Tipo de vinculo inválido");
		}
		GsonBuilder builder = new GsonBuilder();
		builder.addSerializationExclusionStrategy(new ExclusionStrategy() {
			
			@Override
			public boolean shouldSkipField(FieldAttributes f) {
				// TODO Auto-generated method stub
				return f.getName().equals("vinculos");
			}
			
			@Override
			public boolean shouldSkipClass(Class<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
		});
	
		
		Gson gson = builder.create();
		
		return gson.toJson(l);
	}
	
	

}
