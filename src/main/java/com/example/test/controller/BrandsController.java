package com.example.test.controller;

import lombok.AllArgsConstructor;
import com.example.test.dto.brands.BrandRequest;
import com.example.test.dto.brands.BrandResponse;
import com.example.test.service.brand.BrandService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brand")
@AllArgsConstructor
@CrossOrigin
public class BrandsController {
    private final BrandService brandService;

    @GetMapping("/list")
    Page<BrandResponse> getAllBrands(@ParameterObject Pageable pageable) {
        return brandService.getAllBrand(pageable);
    }

    @PostMapping("/create")
    BrandResponse create(@RequestBody BrandRequest brandRequest){
        return brandService.create(brandRequest);
    }
    @GetMapping("/detail")
    BrandResponse getBrandDetail(@RequestParam Long id){
        return brandService.getDetail(id);
    }
    @PutMapping("/update")
    BrandResponse update(@RequestBody BrandRequest brandRequest){
        return brandService.update(brandRequest);
    }
}
