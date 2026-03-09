package com.example.test.mapper;

import com.example.test.dto.category.CategoryRequest;
import com.example.test.dto.category.CategoryResponse;
import com.example.test.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface CategoryMapper {
    CategoryResponse getResponseBy(Category category);
    Category getEntityBy(CategoryRequest categoryRequest);
    void update(@MappingTarget Category category, CategoryRequest categoryRequest);

}
