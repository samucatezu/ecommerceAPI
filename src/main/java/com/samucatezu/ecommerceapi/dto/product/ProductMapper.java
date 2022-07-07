package com.samucatezu.ecommerceapi.dto.product;

import com.samucatezu.ecommerceapi.Model.Product;

public class ProductMapper {

    public static ProductDto getDtoFromProduct(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription()
        );
    }
    public static Product getProductFromDto(ProductDto productDto) {
        return new Product(
                productDto.getName(),
                productDto.getPrice(),
                productDto.getDescription());
    }
}
