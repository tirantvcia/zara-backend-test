package com.zara.test.app.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.zara.test.app.dto.TestData;
import com.zara.test.app.services.ProductService;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ProductService service;
	
	@Test
	void testGetProductDetails() throws Exception {
		when(service.getProductDetails(1L)).thenReturn(TestData.PRODUCT_DETAILS_ID_1);
		mvc.perform(get("/product/1").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value("1"))
		.andExpect(jsonPath("$.name").value("Shirt"))
		.andExpect(jsonPath("$.price").value(9.99))
		.andExpect(jsonPath("$.availability").value(true));
		
	}
	
	@Test
	void testGetProductSimilarIds() throws Exception {
		when(service.getProductSimilarIds(1L)).thenReturn(TestData.SIMILAR_IDS_LIST_AS_ID_1);
		mvc.perform(get("/product/1/similar").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0]").value(2))
		.andExpect(jsonPath("$[1]").value(3))
		.andExpect(jsonPath("$[2]").value(4))
		.andExpect(jsonPath("$").isArray());
	}	
	
}
