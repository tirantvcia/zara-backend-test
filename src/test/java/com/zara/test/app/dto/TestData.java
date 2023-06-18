package com.zara.test.app.dto;

import java.util.Arrays;
import java.util.List;

public class TestData {
	public static final Product PRODUCT_DETAILS_ID_1 = new Product(1L, "Shirt", 9.99, true);
	public static final List<Long> SIMILAR_IDS_LIST_AS_ID_1 = Arrays.asList(2L, 3L, 4L);
}
