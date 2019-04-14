package com.notice.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
@Path("notice")
public class Notice {

	@GET @Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNoticeList() {
		String rmsg = "[GET] Example List";
		return Response.status(200).entity(rmsg).build();
	}
	
	@GET @Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotice(@PathParam("id") Integer id) {
		String rmsg = "[GET] Example ID:" + id;
		return Response.status(200).entity(rmsg).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response postNotice(ModelMap p) {
		String rmsg = "[POST] Create Notice Params: " + p;
		return Response.status(200).entity(rmsg).build();
	}
	
	@PUT @Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response putNotice(@PathParam("id") Integer id) {
		String rmsg = "[PUT] Update Notice ID: " + id;
		return Response.status(200).entity(rmsg).build();
	}
	
	@DELETE @Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteNotice(@PathParam("id") Integer id) {
		String rmsg = "[DELETE] Delete Notice ID: " + id;
		return Response.status(200).entity(rmsg).build();
	}
}
