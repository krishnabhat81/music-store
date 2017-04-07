package com.musicstore.controller;

import com.musicstore.model.Product;
import com.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {

    private Path path;

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
    public String getProductById(@PathVariable int productId, Model model){
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);

        return "viewProduct";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {

        return "admin";
    }

    @RequestMapping(value = "/admin/productInventory", method = RequestMethod.GET)
    public String productInventory(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "productInventory";
    }

    /** DISPLAY ADD PRODUCT FORM**/
    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("New");
        product.setProductStatus("Active");

        model.addAttribute("product", product);
        return "addProduct";
    }

    /** ADD PRODUCT IMPLEMENTATION**/
    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String  addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request) {
        productService.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png");

        if (productImage.getOriginalFilename() != null && !productImage.isEmpty()) {

            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }


        return "redirect:/admin/productInventory";
    }

    /** REMOVE PRODUCT IMPLEMENTATION**/
    @RequestMapping(value = "/admin/productInventory/deleteProduct/{productId}", method = RequestMethod.GET)
    public String  deleteProduct(@PathVariable("productId") int productId)  {
        productService.removeProduct(productId);

        return "redirect:/admin/productInventory";
    }


}
