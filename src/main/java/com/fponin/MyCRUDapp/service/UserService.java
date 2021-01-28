package com.fponin.MyCRUDapp.service;

import com.fponin.MyCRUDapp.model.Role;
import com.fponin.MyCRUDapp.model.User;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();

    User findUser(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User getUserByName(String name);

    Role getRoleByName(String roleName);

    List<Role> getAllRole();

}
