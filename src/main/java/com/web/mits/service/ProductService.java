package com.web.mits.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.web.mits.model.Product;
import com.web.mits.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
