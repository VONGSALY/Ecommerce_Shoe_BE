package com.example.test.service.brand;

import lombok.AllArgsConstructor;
import com.example.test.base.error_success_handle.CodeAndMessage;
import com.example.test.dto.brands.BrandRequest;
import com.example.test.dto.brands.BrandResponse;
import com.example.test.entity.Brands;
import com.example.test.entity.Product;
import com.example.test.mapper.BrandsMapper;
import com.example.test.repository.BrandsRepository;
import com.example.test.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BrandServiceImpl implements BrandService {
    private final BrandsRepository brandsRepository;
    private final BrandsMapper brandsMapper;
    private final ProductRepository productRepository;

    @Override
    public Page<BrandResponse> getAllBrand(Pageable pageable) {
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(Sort.Order.asc("id")));
        Page<Brands> brandsEntities = brandsRepository.findAll(sortedPageable);
        return brandsEntities.map(brandsMapper::getResponseBy);
    }

    @Override
    @Transactional
    public BrandResponse create(BrandRequest brandRequest) {
        Brands brands = brandsMapper.getEntityBy(brandRequest);
        brands.setCreateDate(LocalDate.now());
        brands.setModifyDate(LocalDate.now());
        brandsRepository.save(brands);
        return brandsMapper.getResponseBy(brands);
    }

    @Override
    public BrandResponse getDetail(Long id) {
        Brands brands = brandsRepository.findById(id).orElseThrow(
                () -> new RuntimeException(CodeAndMessage.ERR3)
        );
        return brandsMapper.getResponseBy(brands);
    }

    @Override
    @Transactional
    public BrandResponse update(BrandRequest brandRequest) {
        Brands brands = brandsRepository.findById(brandRequest.getId()).orElseThrow(
                () -> new RuntimeException(CodeAndMessage.ERR3)
        );
        brandsMapper.update(brands, brandRequest);
        brands.setCreateDate(LocalDate.now());
        brands.setModifyDate(LocalDate.now());
        brandsRepository.save(brands);
        List<Product> productEntities = productRepository.findAllByBrandIdIn(Collections.singleton(brands.getId()));
        for(Product product : productEntities){
            if(Boolean.FALSE.equals(brands.getIsActive())){
                product.setIsActive(Boolean.FALSE);
            }else{
                product.setIsActive(Boolean.TRUE);
            }
            productRepository.save(product);
        }
        return brandsMapper.getResponseBy(brands);
    }
}
