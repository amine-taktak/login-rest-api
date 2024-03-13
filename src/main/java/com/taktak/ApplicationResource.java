package com.taktak;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@Path("/MyRestService")
@ApplicationPath("/rest")
public class ApplicationResource extends Application {

    // http://localhost:8080/login-rest-api/rest/MyRestService/sayhi
    @GET
    @Path("/sayhi")
    public Response getHelloMsg() {
        return Response.status(Response.Status.OK).entity("Hi, World").build();
    }
}


