package com.fponin.MyCRUDapp.dao;

import com.fponin.MyCRUDapp.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
