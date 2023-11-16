package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entities.Product;
import com.eclipse.UirShop.entitiesDto.ProductDto;
import com.eclipse.UirShop.exceptions.NotFoundException;
import com.eclipse.UirShop.repositories.ProductsRepository;
import com.eclipse.UirShop.transformers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }



    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product saveProduct = productsRepository.save(product);
        return ProductMapper.mapToProductDto(saveProduct);
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

    public Optional<ProductDto> updateProduct(ProductDto productDto,Long id) {
        Product p=ProductMapper.mapToProduct(productDto);
        Optional<Product> existingProduct = productsRepository.findById(id);
        if(existingProduct.isPresent()){
            Product p1=existingProduct.get();
            p1.setName(p.getName());
            p1.setPrice(p.getPrice());
            p1.setImages(p.getImages());
            p1.setQuantity(p.getQuantity());
            return Optional.of(ProductMapper.mapToProductDto(productsRepository.save(p1)));
        }

return Optional.empty();
    }



    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
}
