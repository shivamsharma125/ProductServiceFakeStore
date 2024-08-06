package com.project.productservicefakestore.services;

import com.project.productservicefakestore.dtos.ProductDto;
import com.project.productservicefakestore.models.Category;
import com.project.productservicefakestore.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    private Product convertProductDtoToProduct(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());

        Category category = new Category();
        category.setTitle(productDto.getCategory());

        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());

        return product;
    }
    public Product getProductById(Long id){
        String fakeStoreURL = "https://fakestoreapi.com/products/" + id;
        ProductDto productDto = restTemplate.getForObject(fakeStoreURL, ProductDto.class);

        if (productDto == null) { return null; }

        return convertProductDtoToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {
        String fakeStoreURL = "https://fakestoreapi.com/products";
        ProductDto[] productDtos = restTemplate.getForObject(fakeStoreURL, ProductDto[].class);

        List<Product> productList = new ArrayList<>();
        for(ProductDto productDto : productDtos){
            productList.add(convertProductDtoToProduct(productDto));
        }

        return productList;
    }
}
