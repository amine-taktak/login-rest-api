package com.taktak.service.authentication;

/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 15.03.21:14
 */

import com.sun.jersey.spi.inject.Inject;
import com.taktak.businesslogic.authentication.AuthenticationLogic;
import com.taktak.businesslogic.exception.NoUserFoundException;
import com.taktak.businesslogic.value.UserBO;
import com.taktak.service.authentication.value.UserCredentialsTO;
import com.taktak.service.provider.UserNotFoundMapper;
import com.taktak.service.value.UserTO;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/authentication")
public class AuthenticationResource implements AuthenticationApi {

    @Inject
    AuthenticationLogic authenticationLogic;

    @Inject
    UserNotFoundMapper userNotFoundMapper;

    @Override
    public Response login(UserCredentialsTO credentials) {

        // Attempt to find the user
        UserBO userBO = authenticationLogic.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());

        if (userBO != null) {
            // Map business object to transport object
            UserTO userTO = mapUserBOToUserTO(userBO);
            // Create JSON response with the user details
            JsonObject jsonResponse = Json.createObjectBuilder()
                    .add("id", userTO.getUserId())
                    .add("firstname", userTO.getFirstname())
                    .add("lastname", userTO.getLastname())
                    .add("username", userTO.getUsername())
                    .add("accessToken", userTO.getAcessToken())
                    .build();
            return Response.status(Response.Status.OK).entity(jsonResponse).build();
        }

        // If authentication fails, return unauthorized response
        return userNotFoundMapper.toResponse(new NoUserFoundException("User not found"));

    }

private static UserTO mapUserBOToUserTO(UserBO userBO) {
    UserTO userTO = new UserTO();
    userTO.setUserId(userBO.getUserId());
    userTO.setFirstname(userBO.getFirstname());
    userTO.setLastname(userBO.getLastname());
    userTO.setUsername(userBO.getUsername());
    userTO.setAcessToken((userBO.getAcessToken()));
    return userTO;
}
}
