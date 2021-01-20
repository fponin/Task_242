package com.fponin.MyCRUDapp.web.controller;

import com.fponin.MyCRUDapp.model.User;
import com.fponin.MyCRUDapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserUpdateController {

    private final UserService userService;

    public UserUpdateController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping(value = "/updateUser/{id}")
    public String getUsers(@PathVariable("id") int id, Model model) {
        model.addAttribute(userService.findUser(id));
        return "upd_user";
    }

    @PatchMapping(value = "/{id}")
    public String updateUsers(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}