package com.project.productservicefakestore.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreAllProductsDto {
    public List<FakeStoreProductDto> productDtos;
}
