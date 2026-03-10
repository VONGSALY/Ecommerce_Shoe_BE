package com.example.test.mapper;

import com.example.test.dto.product.CreateProductRequest;
import com.example.test.dto.product.ProductDtoResponse;
import com.example.test.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ProductMapper {
    ProductDtoResponse getResponseFromEntity(Product product);
    void update (@MappingTarget Product product, CreateProductRequest createProductRequest);
}
