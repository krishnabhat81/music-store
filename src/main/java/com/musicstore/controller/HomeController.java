package com.musicstore.controller;

import com.musicstore.dao.ProductDao;
import com.musicstore.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {
    private ProductDao productDao = new ProductDao();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "productList", method = RequestMethod.GET)
    public String getProduct(Model model) {
        List<Product> products = productDao.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }
}
