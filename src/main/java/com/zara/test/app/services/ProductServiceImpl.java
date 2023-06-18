package com.zara.test.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zara.test.app.dto.Product;
import com.zara.test.app.services.clients.ProductMockClientRest;

@Service
public class ProductServiceImpl implements ProductService  {

	@Autowired
	private ProductMockClientRest feignClient;
	
	@Override
	public List<Long> getProductSimilarIds(Long id) {
		return feignClient.getProductSimilarIds(id);
	}

	@Override
	public Product getProductDetails(Long id) {
		return feignClient.getProductDetails(id);
	}

}
