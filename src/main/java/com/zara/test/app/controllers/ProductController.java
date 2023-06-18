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

@RestController
@RequestMapping("/product/")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public Product getDetails(@PathVariable(name="productId") Long id) {
		return service.getProductDetails(id);
	}
	
	@GetMapping("/{productId}/similar")
	@ResponseStatus(HttpStatus.OK)
	public List<Long> getProductSimilarIds(@PathVariable(name="productId") Long id) {
		return service.getProductSimilarIds(id);
	}
}
