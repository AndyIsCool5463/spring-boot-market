package edu.cps3500.app.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.cps3500.app.domain.Role;
import edu.cps3500.app.domain.User;
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

    @GetMapping("/userhome")
    public String userhome() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        SimpleGrantedAuthority role = (SimpleGrantedAuthority) (auth.getAuthorities().toArray())[0]; // casting
        if (role.getAuthority().equals("USER")) {
            return "user/userhome";
        } else
            return "denied";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserRegistrationDTO()); // change this to DTO
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserRegistrationDTO userDto, BindingResult result) {
        /**
         * FUCKING CHANGE THiS SHIT PUT IT IN ANOTHER FILE PLEASE ITS GIVING RADIATION
         * CANCER.
         */
        System.out.println(userDto.getFirstName());
        System.out.println(userDto.getLastName());
        System.out.println(userDto.getEmail());
        System.out.println(userDto.getConfirmEmail());
        System.out.println(userDto.getPassword());
        System.out.println(userDto.getConfirmPassword());
        User existing = userService.findByUsername(userDto.getEmail());
        System.out.println(userDto.getFirstName());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an email registered idiot.");
        }
        if (userDto.getEmail() != userDto.getConfirmEmail()) {
            result.rejectValue("confirmEmail", null, "Email dont match fucktard.");
        }
        if (userDto.getPassword() != userDto.getConfirmPassword()) {
            result.rejectValue("confirmPassword", null, "Passwords dont match cunt.");
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
}