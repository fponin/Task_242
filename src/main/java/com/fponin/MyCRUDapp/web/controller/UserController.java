package com.fponin.MyCRUDapp.web.controller;

import com.fponin.MyCRUDapp.model.User;
import com.fponin.MyCRUDapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        List<User> usersList = userService.getAllUsers();

        model.addAttribute("usersList", usersList);
        return "users";
    }
}
