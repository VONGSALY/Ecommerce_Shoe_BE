package com.example.test.dto.category;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AttributeDtoRequest {
    private Long size;
    private Double price;
    private Long stock;
}
