package com.example.test.service.voucher;

import com.example.test.dto.voucher.VoucherDtoResponse;
import com.example.test.entity.Voucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VoucherService {

    VoucherDtoResponse getVoucherByCode(String code);
    Page<VoucherDtoResponse> getAllVoucher(Pageable pageable);
    VoucherDtoResponse create(Voucher voucher);
    VoucherDtoResponse getDetail(Long id);
    VoucherDtoResponse update(Voucher voucher);
}
