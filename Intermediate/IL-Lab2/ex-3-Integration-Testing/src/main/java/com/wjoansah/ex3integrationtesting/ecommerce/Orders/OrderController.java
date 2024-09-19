package com.wjoansah.ex3integrationtesting.ecommerce.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "order"; // Thymeleaf template name
    }

    @PostMapping
    public String placeOrder(@ModelAttribute Order order, Model model) {
        orderService.saveOrder(order);
        model.addAttribute("message", "Order placed successfully!");
        return "order";
    }
}
