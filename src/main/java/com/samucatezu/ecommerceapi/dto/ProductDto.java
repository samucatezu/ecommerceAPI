package com.samucatezu.ecommerceapi.dto;


import lombok.*;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private Long Id;

    @NotNull
    private String name;

    @NotNull
    private double price;

    @NotNull
    private String description;



}
