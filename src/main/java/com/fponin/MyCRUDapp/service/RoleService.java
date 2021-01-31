package com.fponin.MyCRUDapp.service;

import com.fponin.MyCRUDapp.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String roleName);

    List<Role> getAllRole();
}
