package com.product.service.productservice.controller;

import com.product.service.productservice.dto.ProductDto;
import com.product.service.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return this.productService.createProduct(productDto);
    }

    @GetMapping("/")
    public List<ProductDto> getAllProducts(){
        return this.productService.getAllCustomerProduct();
    }

}
