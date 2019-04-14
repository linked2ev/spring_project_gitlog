package com.example.rest;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("example")
public class Example {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg() {
		String rmsg = "Hello RESTful ! - Jersey 2 + Spring4";
		return Response.status(200).entity(rmsg).build();
	}
	
	@GET @Path("{str}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExample(@PathParam("str") String str) {
		String rmsg = "[GET] PathParam:" + str;
		return Response.status(200).entity(rmsg).build();
	}
	
	@GET @Path("json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJSONExample() {
		
		HashMap<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("buyer_email", "test@email.com");
		rmap.put("buyer_name", "YOUNG JUN, KIM");
		rmap.put("buyer_tel", "01048111234");
		rmap.put("buyer_country", "KOREA");
		
		return Response.status(200).entity(rmap).build();
	}
	
}
