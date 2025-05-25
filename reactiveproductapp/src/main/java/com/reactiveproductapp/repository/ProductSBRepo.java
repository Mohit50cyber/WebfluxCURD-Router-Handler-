package com.reactiveproductapp.repository;

import com.reactiveproductapp.entity.ProductSB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSBRepo extends JpaRepository<ProductSB,Long> {
}
