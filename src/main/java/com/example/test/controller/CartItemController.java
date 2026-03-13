package com.example.test.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import com.example.test.base.error_success_handle.SuccessResponse;
import com.example.test.dto.cart.CartItemDetailResponse;
import com.example.test.dto.cart.CartItemDtoRequest;
import com.example.test.dto.cart.CartItemDtoResponse;
import com.example.test.service.cartitem.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
@CrossOrigin
public class CartItemController {
    private final CartItemService cartItemService;

    @PostMapping("/modify")
    @Operation(summary = "Add item to cart")
    CartItemDtoResponse modifyCartItem(@RequestBody CartItemDtoRequest cartItemDtoRequest){
        return cartItemService.modifyCartItem(cartItemDtoRequest);
    }

    @GetMapping("/check-stock")
    @Operation(summary = "Kiểm tra số lượng tồn kho")
    Boolean checkStock(@RequestParam Long id, @RequestParam Long quantity){
        return cartItemService.isEnoughStock(id, quantity);
    }
    @GetMapping("/by-account")
    @Operation(summary = "Lấy sản phẩm giỏ hàng của tài khoản")
    List<CartItemDetailResponse> getCartItemByAccount(@RequestParam Long id){
        return cartItemService.getCartItemDetailByAccount(id);
    }

    @PostMapping("/remove")
    @Operation(summary = "Xóa sản phẩm khỏi giỏ hàng")
    SuccessResponse removeCartItem(@RequestBody CartItemDtoRequest cartItemDtoRequest){
        return cartItemService.removeCartItem(cartItemDtoRequest);
    }

}
