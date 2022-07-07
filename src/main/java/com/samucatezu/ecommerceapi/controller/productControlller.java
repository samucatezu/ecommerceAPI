package com.samucatezu.ecommerceapi.controller;

import com.samucatezu.ecommerceapi.Model.Product;
import com.samucatezu.ecommerceapi.dto.ProductDto;
import com.samucatezu.ecommerceapi.exceptions.ApiResponse;
import com.samucatezu.ecommerceapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class productControlller {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<ProductDto> body = productService.listProducts();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody @Valid ProductDto productDto) {
        ProductDto body = productService.addProduct(productDto);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    @PutMapping("/update/{productID}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("productID") Long productID, @RequestBody @Valid ProductDto productDto){
        ProductDto body = productService.updateProduct(productID, productDto);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productID}")
    public ResponseEntity<ApiResponse> deleteProduct (@PathVariable("productID") Long productID) {
        try {
            productService.deleteProduct(productID);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

}
