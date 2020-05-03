package edu.cps3500.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cps3500.app.domain.StockPE;
import edu.cps3500.app.service.StockService;

@Controller
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/pe2growth")
    public String pe2growth(@RequestParam(name = "ticker", required = true) String ticker, Model model) {
        List<StockPE> stockPEs = stockService.getStockPEs(ticker.toLowerCase());
        model.addAttribute("stockPEs", stockPEs);
        return "table";
    }

    @GetMapping("/stocks")
    public String stocks(Model model) {
        List<StockPE> stockPEs = stockService.getAllStocks();
        model.addAttribute("allStocks", stockPEs);
        return "table";
    }

}
