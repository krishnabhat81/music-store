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
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);

    }

    /** ######################## GET PRODUCT BY ID ################## **/
    public Product getProductById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product =  (Product) session.get(Product.class, new Integer(id));
        return product;
    }

    /** ############### GET ALL PRODUCTS ##########################**/
    @SuppressWarnings("unchecked")
    public List<Product> getAllProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "FROM Product";
        List<Product> products =  session.createQuery(sql).list();
        return products;
    }

    /** ################ DELETE PRODUCT BY ID ###########################**/
    public void removeProduct(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
    }

    /** ################## EDIT PRODUCT BY ID ############# **/
    public void editProduct(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }
}
