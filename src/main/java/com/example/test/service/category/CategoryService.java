package com.example.test.service.category;

import com.example.test.dto.category.CategoryRequest;
import com.example.test.dto.category.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<CategoryResponse> getAllCategory(Pageable pageable);
    Page<CategoryResponse> getAllCategoryAdmin(Pageable pageable);
    CategoryResponse create(CategoryRequest categoryRequest);
    CategoryResponse update(CategoryRequest categoryRequest);

    CategoryResponse getDetail(Long id);
}
