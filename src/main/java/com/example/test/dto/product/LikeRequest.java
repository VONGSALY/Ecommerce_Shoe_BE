package com.example.test.dto.product;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LikeRequest {
    private boolean liked;
}
