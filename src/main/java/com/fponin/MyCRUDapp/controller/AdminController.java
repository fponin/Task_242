package com.fponin.MyCRUDapp.controller;

import com.fponin.MyCRUDapp.model.Role;
import com.fponin.MyCRUDapp.model.User;
import com.fponin.MyCRUDapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    //Список всех @User
    @GetMapping()
    public String printUsers(Model model) {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("usersList", usersList);
        return "admin_panel";
    }

    //Удаление @User
    @DeleteMapping(value = "/{id}")
    public String deleteUsers(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    //Сохранить @User
    @GetMapping(value = "/addNewUser")
    public String addNewUsers(Model model) {
        User user = new User();
        model.addAttribute("roles", userService.getAllRole());
        model.addAttribute("user", user);
        return "user";
    }

    @PatchMapping(value = "/user/{id}")
    public String getUsers(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUser(id));
        model.addAttribute("roles", userService.getAllRole());
        return "user";
    }

    @PostMapping("/{id}")
    public String saveUsers(@ModelAttribute("user") User user, @RequestParam("role") String[] role) {
        user.setRoles(getAddRole(role));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    private Set<Role> getAddRole(String[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (String s : role) {
            roleSet.add(userService.getRoleByName(s));
        }
        return roleSet;
    }

}