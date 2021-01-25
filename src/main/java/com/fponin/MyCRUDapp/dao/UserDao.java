package com.fponin.MyCRUDapp.dao;

import com.fponin.MyCRUDapp.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User findUser(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User getUserByName(String name);
}
