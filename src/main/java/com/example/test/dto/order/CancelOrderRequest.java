package com.example.test.dto.order;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CancelOrderRequest {
    private Long id;
    private String description;
}
