package com.zufar.controller;

import com.zufar.domain.Country;
import com.zufar.domain.Sex;
import com.zufar.domain.User;
import com.zufar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class RegistrationController {


    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getHomePage() {
        return "registration";
    }

    @PostMapping("/addUser")
    public String addUser(
            @RequestParam("first_name") String first_name,
            @RequestParam("last_name") String last_name,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("nickname") String nick_name,
            @RequestParam("country") String country,
            @RequestParam("day") int day,
            @RequestParam("month") int month,
            @RequestParam("year") int year,
            @RequestParam("login") String login,
            @RequestParam("psw") String password
    ) {
        String errorMessage = null;
        if (first_name.isEmpty() || last_name.isEmpty() || patronymic.isEmpty() || country.isEmpty() || login.isEmpty() || password.isEmpty() ||
                day == -1 || month == -1 || year == -1) {
            errorMessage = "Error! Some of fields are empty. Please fill all fields.";
            return "registration";
        } else if (!userService.isLoginUnique(login)) {
            errorMessage = "Error! This login exists. Please make your password unique!";
            return "registration";
        }
        LocalDate birthday = LocalDate.of(year, month, day);
        User user = new User(first_name, last_name, patronymic, nick_name, login, password, Sex.valueOf("MALE"), birthday,
                new Country(country));
        userService.save(user);

        return "index";
    }
}