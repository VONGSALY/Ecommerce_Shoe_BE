package com.example.test.mapper;

import com.example.test.dto.attribute.AttributeDtoResponse;
import com.example.test.entity.Attribute;
import org.mapstruct.Mapper;

@Mapper
public interface AttributeMapper {
    AttributeDtoResponse getResponseFromEntity(Attribute attribute);
}
