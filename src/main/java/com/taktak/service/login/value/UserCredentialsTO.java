package com.taktak.service.login.value;

/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 15.03.21:37
 */
public class UserCredentialsTO {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
