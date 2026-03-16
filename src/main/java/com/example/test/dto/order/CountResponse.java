package com.example.test.dto.order;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CountResponse {
    private String name;
    private Long count;
}
