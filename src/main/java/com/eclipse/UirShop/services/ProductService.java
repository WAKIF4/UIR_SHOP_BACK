package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entities.Product;
import com.eclipse.UirShop.entitiesDto.ProductDto;
import com.eclipse.UirShop.exceptions.NotFoundException;
import com.eclipse.UirShop.repositories.ProductsRepository;
import com.eclipse.UirShop.transformers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public ProductDto createProduct(ProductDto productDto) {

         try {
             Product product = ProductMapper.mapToProduct(productDto);
             Product saveProduct = productsRepository.save(product);
             return ProductMapper.mapToProductDto(saveProduct);
         }catch (Exception e) {
             throw new RuntimeException("Error creating Product: " + e.getMessage(), e);
         }

    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productsRepository.findAll();
        return products.stream()
                .map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }


    public ProductDto getProductById(Long id) {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        return ProductMapper.mapToProductDto(product);
    }


    public ProductDto updateProduct(ProductDto productDto) {
        Product existingProduct = productsRepository.findById(productDto.getId()).get();
        existingProduct.setName(productDto.getName());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setImages(productDto.getImages());
        existingProduct.setQuantity(productDto.getQuantity());

        Product updateProduct = productsRepository.save(existingProduct);
        return ProductMapper.mapToProductDto(updateProduct);

    }

    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
}
