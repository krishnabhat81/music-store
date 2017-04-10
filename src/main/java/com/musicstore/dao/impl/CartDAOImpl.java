package com.musicstore.dao.impl;

import com.musicstore.dao.CartDAO;
import com.musicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDAOImpl implements CartDAO{

    private Map<String, Cart> listOfCarts;

    public CartDAOImpl() {
        listOfCarts = new HashMap<>();
    }

    @Override
    public Cart create(Cart cart) {
       if (!listOfCarts.keySet().contains(cart.getCartId())) {
          throw  new IllegalArgumentException(String.format("Cannot create a cart, A cart with given id %s is already exists",
                  cart.getCartId()));
       }
        listOfCarts.put(cart.getCartId(), cart);
       return cart;
    }

    @Override
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        if (!listOfCarts.containsKey(cartId)) {
            throw  new IllegalArgumentException(String.format("Cannot update a cart, A cart with given id %s does not exists",
                    cartId));
        }
        listOfCarts.put(cartId, cart);
    }

    @Override
    public void delete(String cartId) {
        if(!listOfCarts.containsKey(cartId)) {
            throw  new IllegalArgumentException(String.format("Cannot delete a cart, A cart with given id %s does not exists",
                    cartId));
        }
        listOfCarts.remove(cartId);
    }
}
