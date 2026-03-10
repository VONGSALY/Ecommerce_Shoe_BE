package com.example.test.dto.product;

import lombok.*;
import com.example.test.common.IdAndName;
import com.example.test.entity.Attribute;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDetailResponse {
    private Long id;
    private String name;
    private String code;
    private String description;
    private String main;
    private Long discount;
    private List<String> images;
    private List<Attribute> attributes;
    private List<Long> categoryIds;
    private List<IdAndName> categories;
    private Long saleId;
    private Long brandId;
    private String brand;
    private Double price;
    private Long view;
    private Boolean isActive;


}
