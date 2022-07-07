package com.samucatezu.ecommerceapi.service;

import org.springframework.stereotype.Service;

import com.samucatezu.ecommerceapi.repository.CartRepository;

@Service
public class CartService {
    
    private final CartRepository repository;

    public CartService(CartRepository repository) {
        this.repository = repository;
    }


    
}
