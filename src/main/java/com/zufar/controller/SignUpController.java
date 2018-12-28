package com.zufar.controller;

import com.zufar.domain.Country;
import com.zufar.service.CountryService;
import com.zufar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class SignUpController {

    private final UserService userService;
    private final CountryService countryService;

    @Autowired
    public SignUpController(UserService userService, CountryService countryService) {
        this.userService = userService;
        this.countryService = countryService;
    }

    @PostMapping("/registration")
    public String getRegistrationPage(ModelMap modelMap) {
        List<Country> countries = countryService.getAll();
        modelMap.addAttribute("countries", countries);
        return "registrationView";
    }

    @PostMapping("/addUser")
    public String addUser(
            @RequestParam("first_name") String first_name,
            @RequestParam("last_name") String last_name,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("nickname") String nick_name,
            @RequestParam("country") Long country,
            @RequestParam("day") int day,
            @RequestParam("month") int month,
            @RequestParam("year") int year,
            @RequestParam("login") String login,
            @RequestParam("psw") String password
    ) {
        String errorMessage = null;
        if (first_name.isEmpty() || last_name.isEmpty() || patronymic.isEmpty() || country != null || login.isEmpty() || password.isEmpty() ||
                day == -1 || month == -1 || year == -1) {
            errorMessage = "Error! Some of fields are empty. Please fill all fields.";
            return "registrationView";
        } else if (!userService.isLoginUnique(login)) {
            errorMessage = "Error! This login exists. Please make your password unique!";
            return "registrationView";
        }
        LocalDate birthday = LocalDate.of(year, month, day);
//        UserDTO user = new User(first_name, last_name, patronymic, nick_name, login, password, Sex.valueOf("MALE"), birthday,
//                new Country(country));
//        userService.save(user);

        return "index";
    }
}