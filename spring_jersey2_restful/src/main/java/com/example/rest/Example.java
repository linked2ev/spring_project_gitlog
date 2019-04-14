package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/example")
public class Example
{
    @GET
    public String getMsg()
    {
         return "Hello Example!! - Jersey 2";
    }
}
