package com.taktak.service;

/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 15.03.21:14
 */

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/authentication")
public class AuthenticationResource implements AuthenticationApi {

    @Override
    public Response login() {
        return Response.status(Response.Status.OK).entity("Hi, World").build();
    }
}
