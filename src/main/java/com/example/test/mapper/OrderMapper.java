package com.example.test.mapper;

import com.example.test.dto.order.OrderDtoRequest;
import com.example.test.dto.order.OrderDtoResponse;
import com.example.test.entity.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {
    Order getOrderByRequest(OrderDtoRequest orderDtoRequest);
    OrderDtoResponse getResponseByEntity(Order order);
}
