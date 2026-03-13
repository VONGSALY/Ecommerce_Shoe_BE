package com.example.test.service.cartitem;

import com.example.test.base.error_success_handle.SuccessResponse;
import com.example.test.dto.cart.CartItemDetailResponse;
import com.example.test.dto.cart.CartItemDtoRequest;
import com.example.test.dto.cart.CartItemDtoResponse;

import java.util.List;

public interface CartItemService {

    CartItemDtoResponse modifyCartItem(CartItemDtoRequest cartItemDtoRequest);
    Boolean isEnoughStock(Long id, Long quantity);
    List<CartItemDetailResponse> getCartItemDetailByAccount(Long id);
    SuccessResponse removeCartItem(CartItemDtoRequest cartItemDtoRequest);
}
