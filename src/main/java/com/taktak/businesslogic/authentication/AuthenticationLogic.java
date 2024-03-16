package com.taktak.businesslogic.authentication;

import com.sun.jersey.spi.inject.Inject;
import com.taktak.businesslogic.exception.NoUserFoundException;
import com.taktak.businesslogic.value.UserBO;
import com.taktak.persistence.entity.UserEntity;
import com.taktak.persistence.facade.UserFacade;

import java.util.List;

/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 16.03.13:03
 * @Description This class respresents the handling logic for the user authentication
 */
public class AuthenticationLogic {

    @Inject
    UserFacade userFacade;

    public UserBO findByUsernameAndPassword(final String username, String password) {
        List<UserEntity> users = userFacade.findUserByUsernameAndPassword(username, password);

        if (users.size() > 1) {
            throw new NoUserFoundException("Multiple users found with the same username: " + username);
        } else if (users.size() == 1) {
            UserEntity userEntity = users.get(0);

            // Map entity to business object
            UserBO userBO = new UserBO();
            userBO.setUserId(userEntity.getId());
            userBO.setFirstname(userEntity.getFirstname());
            userBO.setLastname(userEntity.getLastname());
            userBO.setUsername(userEntity.getUsername());
            userBO.setAcessToken((userEntity.getAccessToken()));

            return userBO;
        }
        return null;
    }
}
