package com.project.productservicefakestore.services;

import com.project.productservicefakestore.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
}
