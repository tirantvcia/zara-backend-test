package com.zara.test.app.controllers;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.MediaType;

import com.zara.test.app.dto.Product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Zara Backend test", description = "Test for a Zara job proposal")
public interface SwaggerProductController {

	@Operation(summary = "get details from Zara Product by id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", 
			    content = { @Content(mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			      schema = @Schema(implementation = Product.class))})
	})
	Product getDetails( @NotNull @Parameter(name = "productId", description = "product id to check the details" , example = "1") Long id);
	
	@Operation(summary = "get similar Ids from Zara Product by id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", 
			    content = { @Content(mediaType = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			      schema = @Schema(implementation = Product.class))})
	})
	List<Long> getProductSimilarIds(@NotNull @Parameter(name = "productId", description = "product id to check the similar ids" , example = "1") Long id);

}