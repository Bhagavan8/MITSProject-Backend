package com.web.mits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.mits.model.Product;
import com.web.mits.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/api/products")
	public List<Product> getProducts(@RequestParam int page) {
		int pageSize = 10; // Number of products per page
		System.out.println("rhrhy");
		return productService.getProducts(page, pageSize);
	}
}
