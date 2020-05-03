package edu.cps3500.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/stocks")
    public String Stocks() {
        return "stocks";
    }

    @GetMapping("/aapl")
    public String AAPL() {
        return "stocks/aapl";
    }
}