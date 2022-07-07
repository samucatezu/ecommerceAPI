package com.samucatezu.ecommerceapi.service;

import com.samucatezu.ecommerceapi.Model.Product;
import com.samucatezu.ecommerceapi.dto.product.ProductDto;
import com.samucatezu.ecommerceapi.dto.product.ProductMapper;
import com.samucatezu.ecommerceapi.exceptions.ProductNotExistException;
import com.samucatezu.ecommerceapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public ProductDto addProduct(ProductDto productDto) {
        Product product = ProductMapper.getProductFromDto(productDto);
        product = repository.save(product);
        return ProductMapper.getDtoFromProduct(product);
    }

    public ProductDto updateProduct(Long productID, ProductDto productDto) {
        Product product = ProductMapper.getProductFromDto(productDto);
        product.setId(productID);
        product = repository.save(product);
        return ProductMapper.getDtoFromProduct(product);
    }

    public ProductDto getProductById(Long productId) throws ProductNotExistException {
        Product product = repository.findById(productId).orElseThrow(() -> new ProductNotExistException(productId));
        return ProductMapper.getDtoFromProduct(product);
    }

    public void deleteProduct(Long productID) {
        repository.deleteById(productID);
    }
}
