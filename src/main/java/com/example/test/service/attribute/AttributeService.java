package com.example.test.service.attribute;

import com.example.test.dto.attribute.AttributeDtoResponse;

public interface AttributeService {
    AttributeDtoResponse getAttributeByProductId(Long productId, Long size);
    AttributeDtoResponse getAttributeById(Long id);
}
