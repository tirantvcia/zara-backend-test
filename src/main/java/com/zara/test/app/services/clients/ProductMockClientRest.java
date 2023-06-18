package com.zara.test.app.services.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zara.test.app.dto.Product;


@FeignClient(name = "mockproduct", url="${spring.cloud.openfeign.client.config.mockproduct.url}")
public interface ProductMockClientRest {
	@GetMapping("/{productId}/similarids")
	List<Long> getProductSimilarIds(@PathVariable(name = "productId") Long id);
	@GetMapping("/{productId}")
	Product getProductDetails(@PathVariable(name = "productId") Long id);
}
