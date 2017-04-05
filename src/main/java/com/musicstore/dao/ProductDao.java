package com.musicstore.dao;

import com.musicstore.model.Product;

import java.util.List;

public interface ProductDao {

     void addProduct(Product product);

     Product getProductById(int id);

     List<Product> getAllProducts();

     void removeProduct(int id);

}
