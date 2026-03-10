package com.example.test.mapper;

import com.example.test.dto.sale.SaleResponse;
import com.example.test.entity.Sales;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface SaleMapper {
    SaleResponse getResponseBy(Sales sales);
    Sales getEntityBy(SaleResponse saleResponse);
    void update(@MappingTarget Sales sales, SaleResponse saleResponse);
}
