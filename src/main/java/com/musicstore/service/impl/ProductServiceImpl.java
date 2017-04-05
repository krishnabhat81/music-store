package com.musicstore.service.impl;

import com.musicstore.dao.ProductDao;
import com.musicstore.model.Product;
import com.musicstore.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional
    public void addProduct(Product product) {
        this.productDao.addProduct(product);
    }

    @Transactional
    public Product getProductById(int id) {
       return productDao.getProductById(id);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Transactional
    public void removeProduct(int id) {
        productDao.removeProduct(id);
    }
}
