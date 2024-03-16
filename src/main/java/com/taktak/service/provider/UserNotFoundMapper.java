package com.taktak.service.provider;

/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 16.03.13:40
 */
import com.taktak.businesslogic.exception.NoUserFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserNotFoundMapper implements ExceptionMapper<NoUserFoundException> {

    @Override
    public Response toResponse(NoUserFoundException e) {
       return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
    }
}
