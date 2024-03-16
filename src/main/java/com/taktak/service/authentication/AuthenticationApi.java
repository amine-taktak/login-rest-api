package com.taktak.service.authentication;

/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 15.03.21:13
 */

import com.taktak.service.authentication.value.UserCredentialsTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface AuthenticationApi {

    // http://localhost:8080/login-rest-api/rest/authentication/login
    @GET
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response login(final UserCredentialsTO credentials);
}
