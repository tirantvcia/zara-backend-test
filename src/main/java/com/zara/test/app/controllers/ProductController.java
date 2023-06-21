package com.zara.test.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zara.test.app.dto.Product;
import com.zara.test.app.services.ProductService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/product/")
public class ProductController implements SwaggerProductController {

	@Autowired
	private ProductService service;
	
	@Override
	@GetMapping("/{productId}")
	@ResponseStatus(HttpStatus.OK)
	@CircuitBreaker(name = "mockproduct")
	public Product getDetails(@PathVariable(name="productId") Long id) {
		return service.getProductDetails(id);
	}
	
	@Override
	@GetMapping("/{productId}/similar")
	@ResponseStatus(HttpStatus.OK)
	@CircuitBreaker(name = "mockproduct")
	public List<Long> getProductSimilarIds(@PathVariable(name="productId") Long id) {
		return service.getProductSimilarIds(id);
	}
	
}
