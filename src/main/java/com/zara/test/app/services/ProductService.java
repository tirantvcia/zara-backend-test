package com.zara.test.app.services;

import java.util.List;

import com.zara.test.app.dto.Product;

public interface ProductService {

	List<Long> getProductSimilarIds(Long id);

	Product getProductDetails(Long id);

}