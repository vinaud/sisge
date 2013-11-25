package com.sisge.recursos;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sisge.negocio.InterfaceNegocio;
import com.sisge.negocio.Negocio;
import com.sisge.negocio.entidades.Aluno;
import com.sisge.negocio.entidades.Professor;
import com.sisge.negocio.exceptions.ResourceException;
import com.sun.jersey.api.client.ClientResponse.Status;


@Path("vinculos")
public class VinculoResource {
	
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

}
