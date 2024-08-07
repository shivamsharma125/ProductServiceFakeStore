package com.project.productservicefakestore.controllers;

import com.project.productservicefakestore.dtos.ExceptionDto;
import com.project.productservicefakestore.dtos.ProductDto;
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

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        Product response = productService.getProductById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.replaceProduct(id,productDto),HttpStatus.OK);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(RuntimeException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("ArithmeticException handler get called in Controller!");
        exceptionDto.setCode(403);
        return new ResponseEntity<>(exceptionDto, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("RuntimeException handler get called in Controller!");
        exceptionDto.setCode(400);
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
