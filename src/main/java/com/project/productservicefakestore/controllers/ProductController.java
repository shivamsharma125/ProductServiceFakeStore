package com.project.productservicefakestore.controllers;

import com.project.productservicefakestore.dtos.ExceptionDto;
import com.project.productservicefakestore.dtos.ProductDto;
import com.project.productservicefakestore.models.Category;
import com.project.productservicefakestore.models.Product;
import com.project.productservicefakestore.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        Product response = productService.getProductById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<List<Category>> getAllCategories(){
        return null;
    }

    public ResponseEntity<Category> getCategoryByName(){
        return null;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        Product product = productService.createProduct(productDto);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        Product product = productService.updateProduct(id, productDto);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.replaceProduct(id,productDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }

//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<ExceptionDto> handleArithmeticException(RuntimeException ex){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(ex.getMessage());
//        exceptionDto.setCode(403);
//        return new ResponseEntity<>(exceptionDto, HttpStatus.FORBIDDEN);
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException ex){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(ex.getMessage());
//        exceptionDto.setCode(400);
//        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
//    }
}
