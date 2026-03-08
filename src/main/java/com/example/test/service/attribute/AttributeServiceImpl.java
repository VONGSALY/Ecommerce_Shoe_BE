package com.example.test.service.attribute;

import lombok.AllArgsConstructor;
import com.example.test.base.error_success_handle.CodeAndMessage;
import com.example.test.dto.attribute.AttributeDtoResponse;
import com.example.test.entity.Attribute;
import com.example.test.mapper.AttributeMapper;
import com.example.test.repository.AttributeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class AttributeServiceImpl implements AttributeService {
    private final AttributeRepository attributeRepository;
    private final AttributeMapper attributeMapper;

    @Override
    public AttributeDtoResponse getAttributeByProductId(Long productId, Long size) {
        Attribute attribute = attributeRepository.findByProductIdAndSize(productId,size);
        if(Objects.isNull(attribute)) throw new RuntimeException(CodeAndMessage.ERR3);
        return attributeMapper.getResponseFromEntity(attribute);
    }

    @Override
    public AttributeDtoResponse getAttributeById(Long id) {
        Attribute attribute = attributeRepository.findById(id).orElseThrow(
                () -> new RuntimeException(CodeAndMessage.ERR3)
        );
        return attributeMapper.getResponseFromEntity(attribute);
    }
}
