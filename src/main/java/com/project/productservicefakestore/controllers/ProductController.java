package com.project.productservicefakestore.controllers;

import com.project.productservicefakestore.dtos.ProductDto;
import com.project.productservicefakestore.models.Product;
import com.project.productservicefakestore.services.FakeStoreProductService;
import com.project.productservicefakestore.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        return productService.replaceProduct(id,productDto);
    }
}
