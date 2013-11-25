package com.sisge.negocio.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse.Status;


public class ResourceException extends WebApplicationException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceException(Status status,String mensagem){
		
		super(Response.status(status).entity(mensagem).build());

	}

}
