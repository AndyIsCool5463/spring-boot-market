package edu.cps3500.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.cps3500.app.domain.UserForgotPassword;

@Controller
public class DefaultController {
    @GetMapping("/")
    public String Index() {
        return "index";
    }

    @GetMapping("/terms")
    public String Terms() {
        return "terms";
    }

    @GetMapping("/pricing")
    public String Pricing() {
        return "pricing";
    }

    @GetMapping("/markets")
    public String Markets() {
        return "markets";
    }

    @GetMapping("/aapl")
    public String AAPL() {
        return "stocks/aapl";
    }

    @GetMapping("/forgotpass")
    public String forgotPass(Model model) {
        model.addAttribute("user", new UserForgotPassword());
        return "forgotpwd";
    }
}