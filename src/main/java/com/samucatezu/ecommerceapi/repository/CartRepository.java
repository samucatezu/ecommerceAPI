package com.samucatezu.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samucatezu.ecommerceapi.Model.cart.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
    
}
