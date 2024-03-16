package com.taktak.businesslogic.login;/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 16.03.13:03
 */

import com.sun.jersey.spi.inject.Inject;
import com.taktak.businesslogic.value.UserBO;
import com.taktak.persistence.entity.UserEntity;
import com.taktak.persistence.facade.UserFacade;

import java.util.List;

public class LoginService {

    @Inject
    UserFacade userFacade;

    public boolean checkLogin(final String username, final String password) {

        List<UserEntity> users = userFacade.findUserByUsernameAndPassword(username, password);

        return users.size() == 1;
    }

    public UserBO findByUsernameAndPassword(final String username, String password) {
        List<UserEntity> users = userFacade.findUserByUsernameAndPassword(username, password);

        if (users.size() > 1) {
            throw new IllegalStateException("Multiple users found with the same username: " + username);
        } else if (users.size() == 1) {
            UserEntity currentUser = users.get(0);

            // Map entity to business object
            UserBO userBO = new UserBO();
            userBO.setUserId(currentUser.getId());
            userBO.setFirstname(currentUser.getFirstname());
            userBO.setLastname(currentUser.getLastname());
            userBO.setUsername(currentUser.getUsername());
            userBO.setAcessToken((currentUser.getAccessToken()));

            return userBO;
        }
        return null;
    }
}
