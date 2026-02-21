package com.zest.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zest.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}