package com.project.productservicefakestore.services;

import com.project.productservicefakestore.dtos.FakeStoreAllProductsDto;
import com.project.productservicefakestore.dtos.FakeStoreProductDto;
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
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());

        product.setCategory(category);
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());

        return product;
    }
    public Product getProductById(Long id){
        String fakeStoreURL = "https://fakestoreapi.com/products/" + id;
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(fakeStoreURL, FakeStoreProductDto.class);

        if (fakeStoreProductDto == null) { return null; }

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        String fakeStoreURL = "https://fakestoreapi.com/products";
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(fakeStoreURL, FakeStoreProductDto[].class);

        List<Product> productList = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            productList.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return productList;
    }
}
