package com.samucatezu.ecommerceapi.exceptions;

public class ProductNotExistException extends RuntimeException{
    public ProductNotExistException(Long productId) {
        super("Product id is invalid " + productId);
    }
}
