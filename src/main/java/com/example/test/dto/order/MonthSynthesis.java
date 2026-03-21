package com.example.test.dto.order;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MonthSynthesis {
    private Integer month;
    private Long count;
    private Double total;
}
