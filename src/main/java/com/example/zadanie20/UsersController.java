package com.example.zadanie20;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {

    private UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("users")
    @ResponseBody
    String showUsers() {
        String result = "";
        for (User user : userRepository.getUserList()) {
            result += user + "</br>";
        }
        return result;
    }

    @RequestMapping("add")
    String addUser(@RequestParam(value = "imie", required = false) String firstName, @RequestParam(value = "nazwisko", required = false) String lastName,
                   @RequestParam(value = "wiek", required = false, defaultValue = "0") Integer age) {
        if (!firstName.isEmpty() && !lastName.isEmpty() && age != null) {
            userRepository.addUser(firstName, lastName, age);
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }
}
