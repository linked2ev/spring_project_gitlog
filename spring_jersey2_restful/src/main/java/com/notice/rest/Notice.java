package com.notice.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/notice")
public class Notice
{
    @GET
    public String getMsg()
    {
         return "Notice REST Service !! - Jersey 2";
    }
}
