package com.taktak.service.login;

/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 15.03.21:14
 */
import com.sun.jersey.spi.inject.Inject;
import com.taktak.businesslogic.login.LoginService;
import com.taktak.service.login.value.UserCredentialsTO;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/authentication")
public class AuthenticationResource implements AuthenticationApi {

    @Inject
    LoginService loginService;

    @Override
    public Response login(UserCredentialsTO credentials) {

        boolean isAuthenticated = loginService.checkLogin(credentials.getUsername(), credentials.getPassword());

        if (isAuthenticated) {
               loginService.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());

            JsonObject jsonResponse = Json.createObjectBuilder()
                    .add("accessToken", "accessToken")
                    .add("id", 1)
                    .add("username", "tHanks")
                    .add("password", "root")
                    .build();
            return Response.status(Response.Status.OK).entity(jsonResponse).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();

    }
}
