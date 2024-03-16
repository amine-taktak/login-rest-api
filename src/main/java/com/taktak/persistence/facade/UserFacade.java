package com.taktak.persistence.facade;

import com.taktak.persistence.entity.UserEntity;

import javax.persistence.*;
import java.util.List;

/*
 * @Author Amine Taktak
 * @project login-rest-api
 * @created 16.03.12:31
 * @Description  This class serves as the facade for user-related operations with the database
 */
public class UserFacade {

    private EntityManagerFactory entityManagerFactory;

    public UserFacade() {
        // Create an EntityManagerFactory using persistence unit named "loginPU"
        entityManagerFactory = Persistence.createEntityManagerFactory("loginPU");
    }

    public List<UserEntity> findUserByUsernameAndPassword(final String uname, final String pwd) {
        // Create an EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Use JPQL to make the query
        TypedQuery<UserEntity> query = entityManager.createQuery("select u from UserEntity u where u.username = :uname and u.password = :pwd", UserEntity.class);
        query.setParameter("uname", uname);
        query.setParameter("pwd", pwd);
        return query.getResultList();
    }
}
