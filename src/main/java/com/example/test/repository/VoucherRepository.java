package com.example.test.repository;

import com.example.test.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    Voucher findVoucherByCode(String code);
}
