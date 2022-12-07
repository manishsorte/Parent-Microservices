package com.product.service.productservice.service;

import com.product.service.productservice.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllCustomerProduct();
}
