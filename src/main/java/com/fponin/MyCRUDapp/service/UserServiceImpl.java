package com.fponin.MyCRUDapp.service;

import com.fponin.MyCRUDapp.dao.UserDao;
import com.fponin.MyCRUDapp.model.Role;
import com.fponin.MyCRUDapp.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User findUser(int id) {
        return userDao.findUser(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User updatedUser) {
        if (updatedUser.getPassword().isEmpty()) {
            updatedUser.setPassword(findUser(updatedUser.getId()).getPassword());
        }
        updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        userDao.updateUser(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return userDao.getRoleByName(roleName);
    }

    @Override
    public List<Role> getAllRole() {
        return userDao.getAllRole();
    }
}
