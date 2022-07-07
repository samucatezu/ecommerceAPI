package com.samucatezu.ecommerceapi.dto.cart;

import java.util.List;

import com.samucatezu.ecommerceapi.Model.cart.CartItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    List<CartItemDto> items;

}
