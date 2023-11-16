package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entities.Categorie;
import com.eclipse.UirShop.entities.Product;
import com.eclipse.UirShop.entities.SousCategorie;
import com.eclipse.UirShop.entitiesDto.ProductDto;
import com.eclipse.UirShop.exceptions.NotFoundException;
import com.eclipse.UirShop.repositories.ICategorieRepository;
import com.eclipse.UirShop.repositories.ISousCategorieRepository;
import com.eclipse.UirShop.repositories.ProductsRepository;
import com.eclipse.UirShop.transformers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductsRepository productsRepository;
    private final ISousCategorieRepository sousCategorieRepository;

    private final ICategorieRepository categorieRepository;
    @Autowired
    public ProductService(ProductsRepository productsRepository, ISousCategorieRepository sousCategorieRepository, ICategorieRepository categorieRepository) {
        this.productsRepository = productsRepository;
        this.sousCategorieRepository = sousCategorieRepository;
        this.categorieRepository = categorieRepository;
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
        product.setNbview(product.getNbview()+1);
        productsRepository.save(product);
        return ProductMapper.mapToProductDto(product);
    }
    public List<ProductDto> getProductOrderByView(){
        List<Product>products=productsRepository.findByOrderByNbviewDesc();
        return products.stream()
                .map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }


    public Optional<ProductDto> updateProduct(ProductDto productDto,Long id) {
        Product p=ProductMapper.mapToProduct(productDto);
        Optional<Product> existingProduct = productsRepository.findById(id);
        if(existingProduct.isPresent()){
            Product p1=existingProduct.get();
            System.out.println(p.getName());
            p1.setRef(p.getRef());
            p1.setName(p.getName());
            p1.setPrice(p.getPrice());
            p1.setImages(p.getImages());
            p1.setQuantity(p.getQuantity());
            p1.setNbview(p.getNbview());
            return Optional.of(ProductMapper.mapToProductDto(productsRepository.save(p1)));
        }

return Optional.empty();
    }



    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }

    public void findProductByCategorie(Long id){
        Categorie categorie=categorieRepository.findById(id).get();
        List< SousCategorie>findCat=sousCategorieRepository.findSousCategorieByCategorie(categorie);
        List<List<Product>>productList=new ArrayList<>();
        for(SousCategorie s:findCat){
            List<Product>lproduct=productsRepository.findProductBySouscategorie(s);
            productList.add(lproduct);

        }
        System.out.println(productList);
    }
}
