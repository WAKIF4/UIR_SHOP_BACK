package com.eclipse.UirShop.transformers;

import com.eclipse.UirShop.entities.Product;
import com.eclipse.UirShop.entitiesDto.ProductDto;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setRef(product.getRef());
        productDto.setName(product.getName());
        productDto.setPrice( product.getPrice());
        productDto.setImages(product.getImages());
        productDto.setQuantity(product.getQuantity());
        productDto.setNbview(product.getNbview());
        productDto.setSousCategorie(Sous_CategorieTransformer.toDto(product.getSouscategorie()));
        productDto.setStudentDto(StudentTransformer.studentTransformToDto(product.getStudent()));

        return productDto;
    }

    public static Product mapToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setRef(productDto.getRef());
        product.setName(productDto.getName());
        product.setPrice( productDto.getPrice());
        product.setImages(productDto.getImages());
        product.setQuantity(productDto.getQuantity());
        product.setNbview(productDto.getNbview());
        product.setSouscategorie(Sous_CategorieTransformer.toEntity(productDto.getSousCategorie()));
        product.setStudent(StudentTransformer.studentDtoTransformToEntity(productDto.getStudentDto()));
        return product;
    }





}
