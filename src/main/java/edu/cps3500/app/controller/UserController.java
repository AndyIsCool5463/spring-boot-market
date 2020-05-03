package edu.cps3500.app.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.cps3500.app.domain.Role;
import edu.cps3500.app.domain.User;
import edu.cps3500.app.domain.UserForgotPassword;
import edu.cps3500.app.domain.UserRegistrationDTO;
import edu.cps3500.app.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserRegistrationDTO()); // change this to DTO
        return "register";
    }

    @GetMapping("/userhome")
    public String userHome(Model model) {
        return "user/home";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserRegistrationDTO userDto, BindingResult result) {
        User existing = userService.findByUsername(userDto.getEmail());
        System.out.println(userDto.getTerms());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an email registered idiot.");
        }
        if (!userDto.getEmail().equals(userDto.getConfirmEmail())) {
            result.rejectValue("confirmEmail", null, "Email dont match fucktard.");
        }
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            result.rejectValue("confirmPassword", null, "Passwords dont match cunt.");
        }
        if (!userDto.getTerms()) {
            result.rejectValue("terms", null, "Please check the terms.");
        }
        if (result.hasErrors()) {
            return "register";
        }
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new Role("USER"));
        User newUser = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(),
                passwordEncoder().encode(userDto.getPassword()), roles);
        userService.save(newUser);
        return "redirect:/register?success";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@ModelAttribute("user") @Valid UserForgotPassword ufp, BindingResult result) {
        User existing = userService.findByUsername(ufp.getEmail());
        if (existing == null) {
            result.rejectValue("email", null, "Couldn't find an account that exists with that email.");
        }
        if (result.hasErrors()) {
            return "forgotpwd";
        }
        return "redirect:/forgotpass?sent";
    }
}