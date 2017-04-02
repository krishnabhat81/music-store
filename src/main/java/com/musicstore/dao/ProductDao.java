package com.musicstore.dao;

import com.musicstore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private List<Product> productList;

    public List<Product> getProductList() {
        Product product = new Product();
        productList = new ArrayList<Product>();

        product.setProductName("Guitar1");
        product.setProductCategory("Instrument");
        product.setProductDescription("This is a fender start guitar");
        product.setProductPrice(1200);
        product.setProductCondition("New");
        product.setProductStatus("Active");
        product.setUnitInStock(11);
        product.setProductManufacturer("Fender");



        productList.add(product);
        return productList;
    }
}
