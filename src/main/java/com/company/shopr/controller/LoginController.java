package com.company.shopr.controller;

import com.company.shopr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping(value = "/selectUser")
    public String selectUserPage(Model model) {
        model.addAttribute("allUsers", userService.findAllUsers());
        return "selectUser";
    }
}
