package com.zara.test.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zara.test.app.dto.TestData;
import com.zara.test.app.services.clients.ProductMockClientRest;

@SpringBootTest
class ProductServiceTest {

	

	@MockBean
	private ProductMockClientRest feignClient;
	
	@Autowired
	private ProductService service;
	

	
	@Test
	void testGetProductSimilarIds() {
		Long productId = 1L;
		
		when(feignClient.getProductSimilarIds(productId)).thenReturn(TestData.SIMILAR_IDS_LIST_AS_ID_1);
		
		List<Long> productSimilarIds = service.getProductSimilarIds(productId);
		assertTrue(productSimilarIds.size() == 3);
		assertEquals(2L, productSimilarIds.get(0));
		assertEquals(3L, productSimilarIds.get(1));
		assertEquals(4L, productSimilarIds.get(2));
		
	}

}
