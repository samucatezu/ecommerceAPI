package com.samucatezu.ecommerceapi.dto.cart;

import javax.validation.constraints.NotNull;

import com.samucatezu.ecommerceapi.Model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

    private Long id;
    private Long cartItemId;
    @NotNull
    private Product product;
    @NotNull
    private int quantity;

}
