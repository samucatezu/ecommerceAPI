package com.samucatezu.ecommerceapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samucatezu.ecommerceapi.Model.cart.Cart;
import com.samucatezu.ecommerceapi.repository.CartRepository;
import com.samucatezu.ecommerceapi.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    
    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    

    @GetMapping
    public ResponseEntity<Object> getCart(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.ACCEPTED);
    }
}
