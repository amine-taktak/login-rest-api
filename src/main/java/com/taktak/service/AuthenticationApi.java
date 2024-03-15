package com.taktak.service;/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 15.03.21:13
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

public interface AuthenticationApi {

    // http://localhost:8080/login-rest-api/rest/authentication/login
    @GET
    @Path("/login")
    Response login();
}
