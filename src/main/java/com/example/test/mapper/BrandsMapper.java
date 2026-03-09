package com.example.test.mapper;

import com.example.test.dto.brands.BrandRequest;
import com.example.test.dto.brands.BrandResponse;
import com.example.test.entity.Brands;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface BrandsMapper {
    BrandResponse getResponseBy(Brands brands);
    Brands getEntityBy(BrandRequest brandRequest);
    void update(@MappingTarget Brands brands, BrandRequest brandRequest);
}
