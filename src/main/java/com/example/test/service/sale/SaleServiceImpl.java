package com.example.test.service.sale;

import lombok.AllArgsConstructor;
import com.example.test.base.error_success_handle.CodeAndMessage;
import com.example.test.dto.sale.SaleResponse;
import com.example.test.entity.Product;
import com.example.test.entity.Sales;
import com.example.test.mapper.SaleMapper;
import com.example.test.repository.ProductRepository;
import com.example.test.repository.SalesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class SaleServiceImpl implements SaleService{
    private final SalesRepository salesRepository;
    private final SaleMapper saleMapper;
    private final ProductRepository productRepository;
    @Override
    public Page<SaleResponse> getAllSale(Pageable pageable) {
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(Sort.Order.asc("id")));
        Page<Sales> entities = salesRepository.findAll(sortedPageable);
        return entities.map(saleMapper::getResponseBy);
    }

    @Override
    @Transactional
    public SaleResponse create(SaleResponse saleResponse) {
        Sales sales = saleMapper.getEntityBy(saleResponse);
        sales.setCreateDate(LocalDate.now());
        sales.setModifyDate(LocalDate.now());
        salesRepository.save(sales);
        return saleMapper.getResponseBy(sales);
    }

    @Override
    public SaleResponse getDetailSale(Long id) {
        Sales sales = salesRepository.findById(id).orElseThrow(
                () -> new RuntimeException(CodeAndMessage.ERR3)
        );
        return saleMapper.getResponseBy(sales);
    }

    @Override
    @Transactional
    public SaleResponse update(SaleResponse saleResponse) {
        Sales sales = salesRepository.findById(saleResponse.getId()).orElseThrow(
                () -> new RuntimeException(CodeAndMessage.ERR3)
        );
        saleMapper.update(sales,saleResponse);
        sales.setCreateDate(LocalDate.now());
        sales.setModifyDate(LocalDate.now());
        List<Product> products = productRepository.findAllBySaleId(sales.getId());
        if(Boolean.FALSE.equals(sales.getIsActive())){
            for(Product product : products){
                product.setSaleId(2L);
                productRepository.save(product);
            }
        }
        return saleMapper.getResponseBy(sales);
    }

}
