package com.musicstore.service;

import com.musicstore.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();

    void deleteProduct(String id);
}
