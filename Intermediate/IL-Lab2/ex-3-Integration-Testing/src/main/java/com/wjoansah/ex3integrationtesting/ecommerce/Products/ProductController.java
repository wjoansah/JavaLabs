package com.wjoansah.ex3integrationtesting.ecommerce.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/all")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        System.out.println(products.getFirst());
        model.addAttribute("products", products);
        return "products";
    }
}
