import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.samucatezu.ecommerceapi.Model.Product;
import com.samucatezu.ecommerceapi.Model.cart.Cart;
import com.samucatezu.ecommerceapi.Model.cart.CartItem;

public class CartMapper {

    public static CartDto getDtoFromCart(Cart cart) {
        return new CartDto(
            cart.getId(),
            cart.getItems().stream().map(CartMapper::getDtoFromCartItem).collect(Collectors.toList())
        );
    }

    public static CartItemDto getDtoFromCartItem(CartItem item){
        return new CartItemDto(item.getId(), item.getProduct(), item.getQuantity());
    }

    // public static CartItem getItemCartFromDto(CartItemDto item ){
    //     return new CartItem(item.getId(), item.getProduct(), item.getQuantity());
    // }
}