package com.example.test.dto.order;

import lombok.*;
import com.example.test.entity.OrderDetail;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDtoRequest {
    private String fullName;
    private String phone;
    private String address;
    private String note;
    private Double total;
    private String email;
    private Boolean isPending;
    private Long accountId;
    private Collection<OrderDetail> orderDetails;
    private String code; // voucherCode
    private String payment;
}
