package com.musicstore.dao;

import com.musicstore.model.Cart;

public interface CartDAO {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);
}
