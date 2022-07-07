package com.samucatezu.ecommerceapi.repository;

import com.samucatezu.ecommerceapi.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
