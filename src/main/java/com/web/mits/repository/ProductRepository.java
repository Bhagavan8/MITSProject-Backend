package com.web.mits.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.web.mits.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
