package com.musicstore.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private String cartId;
    private Map<Integer, CartItem> cartItems;
    private double grandTotal;

    public Cart() {
        cartItems = new HashMap<>();
        this.grandTotal = 0;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public void addCartItem(CartItem item) {
        int productId = item.getProduct().getProductId();

        if (cartItems.containsKey(productId)) {
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
            cartItems.put(productId, existingCartItem);

        } else {
            cartItems.put(productId, item);
        }
        updateGrandTotal();
    }

    public void removeCartItem(CartItem item) {
        int productId = item.getProduct().getProductId();
        cartItems.remove(productId);

        updateGrandTotal();
    }

    public void updateGrandTotal() {
       grandTotal = 0;

       for (CartItem item: cartItems.values()) {
           grandTotal += item.getTotalPrice();
       }
    }
}
