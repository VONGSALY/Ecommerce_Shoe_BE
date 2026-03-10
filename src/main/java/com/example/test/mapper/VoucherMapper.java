package com.example.test.mapper;

import com.example.test.dto.voucher.VoucherDtoResponse;
import com.example.test.entity.Voucher;
import org.mapstruct.Mapper;

@Mapper
public interface VoucherMapper {
    VoucherDtoResponse getResponseByEntity(Voucher voucher);
}
