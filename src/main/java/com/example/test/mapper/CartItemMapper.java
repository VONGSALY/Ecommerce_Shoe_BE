package com.example.test.mapper;

import com.example.test.dto.cart.CartItemDtoRequest;
import com.example.test.dto.cart.CartItemDtoResponse;
import com.example.test.entity.CartItem;
import org.mapstruct.Mapper;

@Mapper
public interface CartItemMapper {
    CartItem getEntityByRequest(CartItemDtoRequest cartItemDtoRequest);
    CartItemDtoResponse getResponseFrom(CartItem cartItem);
}
