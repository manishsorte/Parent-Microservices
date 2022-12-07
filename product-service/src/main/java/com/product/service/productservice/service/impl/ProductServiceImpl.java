package com.product.service.productservice.service.impl;

import com.product.service.productservice.dto.ProductDto;
import com.product.service.productservice.entity.Product;
import com.product.service.productservice.repository.ProductRepository;
import com.product.service.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product savedProduct = this.productRepository.save(this.dtoToProduct(productDto));
        log.info("product is savedProduct" + savedProduct);
        return this.productToDto(savedProduct);
    }

    @Override
    public List<ProductDto> getAllCustomerProduct() {
        List<Product> getProducts = this.productRepository.findAll();
        return getProducts.stream()
                .map(this::productToDto)
                .toList();
    }

    private Product dtoToProduct(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

    private ProductDto productToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
}
