package com.fponin.MyCRUDapp.web.controller;

import com.fponin.MyCRUDapp.dao.UserDaoImpl;
import com.fponin.MyCRUDapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        List<User> usersList = new ArrayList<>();
//        usersList.add(new User("123","qwe","qwe","ghjgfhj","sdgfkjghdkfjgh"));

        UserDaoImpl userDao = new UserDaoImpl();
        usersList.addAll(userDao.getAllUsers());

        model.addAttribute("usersList", usersList);
        return "users";
    }
}
