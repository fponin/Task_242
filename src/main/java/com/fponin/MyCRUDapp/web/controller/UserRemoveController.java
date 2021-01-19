package com.fponin.MyCRUDapp.web.controller;

import com.fponin.MyCRUDapp.model.User;
import com.fponin.MyCRUDapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserRemoveController {

    private final UserService userService;

    public UserRemoveController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUsers(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}