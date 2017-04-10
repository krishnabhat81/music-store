package com.musicstore.controller;

import com.musicstore.dao.CartDAO;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
import com.musicstore.model.Product;
import com.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody
    Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartDAO.read(cartId);
    }

    @RequestMapping(value = "/{cardId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cardId") String cardId, @RequestBody Cart cart) {
        cartDAO.update(cardId, cart);
    }

    @RequestMapping(value = "/{cardId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cardId") String cardId) {
        cartDAO.delete(cardId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addCartItem(@PathVariable(value = "productId") int productId, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Cart cart = cartDAO.read(sessionId);

        if (cart == null) {
            cart = cartDAO.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException(new Exception());
        }
        cart.addCartItem(new CartItem(product));
        cartDAO.update(sessionId, cart);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCartItem(@PathVariable(value = "productId") int productId, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Cart cart = cartDAO.read(sessionId);

        if (cart == null) {
            cart = cartDAO.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException(new Exception());
        }
        cart.removeCartItem(new CartItem(product));
        cartDAO.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception ex) {

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception ex) {

    }
}
