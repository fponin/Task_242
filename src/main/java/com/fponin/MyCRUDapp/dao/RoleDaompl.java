package com.fponin.MyCRUDapp.dao;

import com.fponin.MyCRUDapp.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaompl implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Role getRoleByName(String roleName) {
        @SuppressWarnings("unchecked")
        List<Role> resultList = entityManager.createQuery("from Role where roleName=?1")
                .setParameter(1, roleName)
                .getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public List<Role> getAllRole() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }
}
