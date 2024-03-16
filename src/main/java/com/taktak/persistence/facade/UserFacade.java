package com.taktak.persistence.facade;/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 16.03.12:31
 */

import com.sun.jersey.spi.inject.Inject;
import com.taktak.persistence.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserFacade {

    @Inject
    private EntityManager entityManager;

    public List<UserEntity> findUserByUsernameAndPassword(final String uname, final String pwd) {
        // Use JPQL to make the query
        TypedQuery<UserEntity> query = entityManager.createQuery("select u from UserEntity u where u.username =: uname and u.password := pwd", UserEntity.class);
        query.setParameter("uname", uname);
        query.setParameter("pwd", pwd);
        return query.getResultList();
    }
}
