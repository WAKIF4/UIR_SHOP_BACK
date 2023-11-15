package com.eclipse.UirShop.transformers;

import com.eclipse.UirShop.entities.Product;
import com.eclipse.UirShop.entitiesDto.ProductDto;

public class ProductMapper {

    /*
    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
    */

    public static ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getRef(),
                product.getName(),
                product.getPrice(),
                product.getImages(),
                product.getQuantity()
        );
        return productDto;
    }

    public static Product mapToProduct(ProductDto productDto) {
        Product product = new Product(
                productDto.getRef(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getImages(),
                productDto.getQuantity()
        );
        return product;
    }





}
