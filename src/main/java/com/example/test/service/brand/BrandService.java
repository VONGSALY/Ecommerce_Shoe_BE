package com.example.test.service.brand;

import com.example.test.dto.brands.BrandRequest;
import com.example.test.dto.brands.BrandResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandService {
    Page<BrandResponse> getAllBrand(Pageable pageable);
    BrandResponse create(BrandRequest brandRequest);
    BrandResponse getDetail(Long id);
    BrandResponse update(BrandRequest brandRequest);
}
