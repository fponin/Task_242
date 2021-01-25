package com.fponin.MyCRUDapp.controller;

import com.fponin.MyCRUDapp.model.User;
import com.fponin.MyCRUDapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserAddController {

    private final UserService userService;

    public UserAddController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUsers(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @GetMapping(value = "/saveUser")
    public String saveUsers(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}