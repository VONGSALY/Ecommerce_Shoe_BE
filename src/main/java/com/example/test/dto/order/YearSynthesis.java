package com.example.test.dto.order;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class YearSynthesis {
    private Long year;
    private Long count;
    private Double total;
}
