package com.samucatezu.ecommerceapi.controller;

import com.samucatezu.ecommerceapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class productControlller {

    @Autowired
    ProductService productService;

    

}
