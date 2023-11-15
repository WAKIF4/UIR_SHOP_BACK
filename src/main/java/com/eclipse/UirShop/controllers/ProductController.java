package com.eclipse.UirShop.controllers;

import com.eclipse.UirShop.entitiesDto.ProductDto;
import com.eclipse.UirShop.services.ProductService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private ProductService productService;

    // http://localhost:8080/api/products
    @GetMapping
    public ResponseEntity<List<ProductDto>> getALlProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //http://localhost:8080/api/products
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product) {
        ProductDto saveProduct = productService.createProduct(product);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/products/1
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
        ProductDto product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    //http://localhost:8080/api/products/1
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id,
                                                    @RequestBody ProductDto productDto) {
        ProductDto updateProduct = productService.updateProduct(productDto);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    // http://localhost:8080/api/products/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product successfully deleted!", HttpStatus.OK);
    }

}
