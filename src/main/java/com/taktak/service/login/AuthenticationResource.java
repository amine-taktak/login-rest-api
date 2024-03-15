package com.taktak.service.login;

/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 15.03.21:14
 */
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/authentication")
public class AuthenticationResource implements AuthenticationApi {

    @Override
    public Response login(UserCredentialsTO credentials) {
        // mock the response
        JsonObject jsonResponse = Json.createObjectBuilder()
                .add("accessToken", "accessToken")
                .add("id", 1)
                .add("username", "tHanks")
                .add("password", "root")
                .build();
        return Response.status(Response.Status.OK).entity(jsonResponse).build();
    }
}
