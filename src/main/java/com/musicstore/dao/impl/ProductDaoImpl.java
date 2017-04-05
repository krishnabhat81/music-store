package com.musicstore.dao.impl;

import com.musicstore.dao.ProductDao;
import com.musicstore.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /** ################### ADD PRODUCT ################### **/
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }

    /** ######################## GET PRODUCT BY ID ################## **/
    public Product getProductById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Product product =  (Product) session.get(Product.class, id);
        return product;
    }

    /** ############### GET ALL PRODUCTS ##########################**/
    @SuppressWarnings("unchecked")
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products =  session.createQuery("from Product").list();
        return products;
    }

    /** ################ DELETE PRODUCT BY ID ###########################**/
    public void deleteProduct(String id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
    }
}
