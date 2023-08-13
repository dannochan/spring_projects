package com.example.mgtsystemlogin.controller;

import com.example.mgtsystemlogin.dto.UserRegisterDTO;
import com.example.mgtsystemlogin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

//    @ModelAttribute("user")
//    public UserRegisterDTO userRegisterDTO(){
//        return new UserRegisterDTO();
//    }
    @GetMapping("/login")
    public String logIn(){

        return "login";
    }

    @GetMapping("/register")
    public String showRegister( Model page){

        page.addAttribute("user", new UserRegisterDTO());

        return "registration";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserRegisterDTO userRegisterDTO){

        userService.save(userRegisterDTO);

        return "redirect:/register?success";
    }
}
