package com.example.test.repository;

import com.example.test.entity.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, Long> {
    List<Brands> findAllByIdIn(Collection<Long> ids);
}
