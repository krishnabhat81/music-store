package com.musicstore.dao;

import com.musicstore.model.Product;

import java.util.List;

public interface ProductDao {

     void addProduct(Product product);

     Product getProductById(String id);

     List<Product> getAllProducts();

     void deleteProduct(String id);

}
