package com.fponin.MyCRUDapp.dao;

import com.fponin.MyCRUDapp.model.Role;

import java.util.List;

public interface RoleDao {
    Role getRoleByName(String roleName);

    List<Role> getAllRole();
}
