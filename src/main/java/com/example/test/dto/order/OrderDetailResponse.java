package com.example.test.dto.order;

import lombok.*;
import com.example.test.dto.attribute.AttributeDtoResponse;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDetailResponse {
    private Long id;
    private Double originPrice;
    private String image;
    private Long quantity;
    private Double sellPrice;
    private AttributeDtoResponse attribute;
    private Long attributeSize;
    private String orderStatusName;
    private Long orderId;
    private Long discount;
}
