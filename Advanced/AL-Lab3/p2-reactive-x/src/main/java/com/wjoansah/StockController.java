package com.wjoansah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/stocks")
    public String getStocks(Model model) {
        var responseMono = stockService.observeStockPrices();

        responseMono.subscribe(response -> {
            System.out.println(response);
            if (response == null || response.getGlobalQuote() == null) {
                model.addAttribute("error", "Stock data is unavailable.");
            } else {
                model.addAttribute("stockResponse", response);
            }
        });

        return "stocks";
    }
}


