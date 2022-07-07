package com.samucatezu.ecommerceapi.service;

import com.samucatezu.ecommerceapi.Model.Product;
import com.samucatezu.ecommerceapi.dto.ProductDto;
import com.samucatezu.ecommerceapi.dto.ProductMapper;
import com.samucatezu.ecommerceapi.exceptions.ProductNotExistException;
import com.samucatezu.ecommerceapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductDto> listProducts() {
        List<Product> products = repository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = ProductMapper.getDtoFromProduct(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public void addProduct(ProductDto productDto) {
        Product product = ProductMapper.getProductFromDto(productDto);
        repository.save(product);
    }

    public void updateProduct(Long productID, ProductDto productDto) {
        Product product = ProductMapper.getProductFromDto(productDto);
        product.setId(productID);
        repository.save(product);
    }

    public Product getProductById(Long productId) throws ProductNotExistException {
        return repository.findById(productId).orElseThrow(() -> new ProductNotExistException(productId));
    }
}
