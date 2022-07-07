package com.samucatezu.ecommerceapi.Model;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private double price;

    @NotNull
    private String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
