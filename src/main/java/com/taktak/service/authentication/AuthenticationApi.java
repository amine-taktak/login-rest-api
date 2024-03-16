package com.taktak.service.authentication;

/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 15.03.21:13
 */

import com.taktak.service.authentication.value.UserCredentialsTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface AuthenticationApi {

    /**  Attempts to log into the application (http://localhost:8080/login-rest-api/rest/authentication/login).
     *
     * @param credentials The Credentials (username and password) used for login.
     *
     * @return A Response, containing user details if the login is successful,
     *         or an error response if the user is no found.
     */
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response login(final UserCredentialsTO credentials);
}
