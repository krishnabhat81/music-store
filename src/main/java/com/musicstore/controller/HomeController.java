package com.musicstore.controller;

import com.musicstore.model.Product;
import com.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "productList", method = RequestMethod.GET)
    public String getProduct(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping(value = "productList/viewProduct/{productId}", method = RequestMethod.GET)
    public String getProductById(@PathVariable String productId, Model model){
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "viewProduct";
    }



}
