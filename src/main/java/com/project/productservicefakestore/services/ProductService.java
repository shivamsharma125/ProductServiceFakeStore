package com.project.productservicefakestore.services;

import com.project.productservicefakestore.dtos.ProductDto;
import com.project.productservicefakestore.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product replaceProduct(Long id, ProductDto productDto);
    Product updateProduct(Long id, ProductDto productDto);
    Product createProduct(ProductDto productDto);
    Product deleteProduct(Long id);
}
