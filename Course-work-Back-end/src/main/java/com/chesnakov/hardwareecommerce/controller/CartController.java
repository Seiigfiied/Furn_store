package com.chesnakov.hardwareecommerce.controller;

import com.chesnakov.hardwareecommerce.dao.CartDao;
import com.chesnakov.hardwareecommerce.entity.Cart;
import com.chesnakov.hardwareecommerce.service.CartService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://46.253.143.107:4200")
@RestController
public class CartController {
    private final CartService cartService;
    private final CartDao cartDao;
    public CartController(CartService cartService,
                          CartDao cartDao) {
        this.cartService = cartService;
        this.cartDao = cartDao;
    }
    @PreAuthorize("hasRole('User')")
    @GetMapping({"/addToCart/{productId}"})
    public Cart addToCart(@PathVariable("productId") Long productId) {
        return cartService.addToCart(productId);
    }
    @PreAuthorize("hasRole('User')")
    @GetMapping({"/getCartDetails"})
    public List<Cart> getCartDetails() {
        return cartService.getCartDetails();
    }

    @PreAuthorize("hasRole('User')")
    @DeleteMapping({"/deleteCartItem/{cartId}"})
    public void deleteCartItem(@PathVariable("cartId") Long cartId) {
        cartService.deleteCartItem(cartId);
    }
}
