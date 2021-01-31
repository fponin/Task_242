package com.fponin.MyCRUDapp.service;

import com.fponin.MyCRUDapp.dao.RoleDao;
import com.fponin.MyCRUDapp.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }

    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }
}
