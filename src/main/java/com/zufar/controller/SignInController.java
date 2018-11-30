package com.zufar.controller;

import com.zufar.domain.User;
import com.zufar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {

    private final UserService userService;

    @Autowired
    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signIn")
    public String addUser(@RequestParam("login") String login, @RequestParam("psw") String password) {
        String errorMessage = null;
        if (login.isEmpty() || password.isEmpty()) {
            errorMessage = "Error. Some of fields are empty. Please fill all fields.";
        }
        User user = userService.get(login, password);
        if (user == null) {
            errorMessage = "Error. Wrong login or password. Please try again.";
        }
        return "index";
    }
}