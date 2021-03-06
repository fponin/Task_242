package com.fponin.MyCRUDapp.controller;

import com.fponin.MyCRUDapp.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/info")
    public String printUserInfo(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute(userService.getUserByName(auth.getName()));
        return "user_info";
    }
}