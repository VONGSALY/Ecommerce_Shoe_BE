package com.example.test.controller;

import lombok.AllArgsConstructor;
import com.example.test.dto.sale.SaleResponse;
import com.example.test.service.sale.SaleService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sale")
@AllArgsConstructor
@CrossOrigin
public class SaleController {
    private final SaleService saleService;

    @GetMapping("/list")
    public Page<SaleResponse> getAllSale(@ParameterObject Pageable pageable){
        return saleService.getAllSale(pageable);
    }
    @PostMapping("/create")
    SaleResponse create(@RequestBody SaleResponse saleResponse){
        return saleService.create(saleResponse);
    }
    @GetMapping("/detail")
    SaleResponse getDetailSale(@RequestParam Long id){
        return saleService.getDetailSale(id);
    }
    @PostMapping("/update")
    SaleResponse update(@RequestBody SaleResponse saleResponse){
        return saleService.update(saleResponse);
    }
}
