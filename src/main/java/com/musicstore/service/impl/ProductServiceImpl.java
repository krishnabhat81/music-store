package com.musicstore.service.impl;

import com.musicstore.dao.ProductDao;
import com.musicstore.model.Product;
import com.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }


    public void addProduct(Product product) {
        this.productDao.addProduct(product);
    }

    public Product getProductById(String id) {
        return null;
    }

    public List<Product> getAllProducts() {
        return null;
    }

    public void deleteProduct(String id) {

    }
}
