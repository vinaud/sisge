package com.sisge.recursos;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sisge.negocio.Negocio;
import com.sisge.negocio.entidades.Turma;
import com.sisge.negocio.exceptions.ResourceException;
import com.sun.jersey.api.client.ClientResponse.Status;


@Path("turmas")
public class TurmaResource {
	
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrar(String turma) {
		
		Negocio n = Negocio.getInstancia();
		GsonBuilder gBuilder = new GsonBuilder();
		Gson gson = gBuilder.create();
		Turma t = gson.fromJson(turma, Turma.class);
		try {
			n.cadastrarTurma(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResourceException(Status.EXPECTATION_FAILED, "SQLException");
		}
		
	}

}
