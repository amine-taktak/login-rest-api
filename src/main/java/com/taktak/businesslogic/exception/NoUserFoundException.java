package com.taktak.businesslogic.exception;

/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 16.03.13:33
 */
public class NoUserFoundException extends RuntimeException{

    public NoUserFoundException(final String username) {
        super("User not found with username: " + username);
    }
}
