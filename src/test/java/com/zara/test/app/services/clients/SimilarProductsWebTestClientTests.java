package com.zara.test.app.services.clients;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.zara.test.app.dto.Product;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SimilarProductsWebTestClientTests {	
	
	@Value("${spring.cloud.openfeign.client.config.mockproduct.url}")
	private String uriProviderProduct;
	
	@Autowired
	private WebTestClient client;
	
	@Test
	void testGetProductSimilarIds() {
		String productId = "1";
		client.get().uri(String.format(uriProviderProduct+"%s/similarids", productId)).exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$[0]").isEqualTo(2)
		.jsonPath("$[1]").isEqualTo(3)
		.jsonPath("$[2]").isEqualTo(4)
		.jsonPath("$").isArray();
	}
	
	@Test
	void testGetProductDetails() {
		String productId = "1";
		client.get().uri(String.format(uriProviderProduct+"%s", productId)).exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$.id").isEqualTo("1")
		.jsonPath("$.name").isEqualTo("Shirt")
		.jsonPath("$.price").isEqualTo(9.99)
		.jsonPath("$.availability").isEqualTo(true);
	}
	
	@Test
	void testGetProductDetailsAsProductPojo() {
		String productId = "1";
		client.get().uri(String.format(uriProviderProduct+"%s", productId)).exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody(Product.class)
		.consumeWith(response -> {
			Product product = response.getResponseBody();
			assertEquals("1", product.getId().toString());
			assertEquals("Shirt", product.getName());
			assertEquals(9.99, product.getPrice());
			assertEquals(true, product.isAvailability());
		});
		
	}
	
	@Test
	void testGetProductNotFounf() {
		String productId = "100001";
		client.get().uri(String.format(uriProviderProduct+"%s", productId)).exchange()
		.expectStatus().isNotFound();
		
	}
}
