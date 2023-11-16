package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.Categorie;
import com.eclipse.UirShop.entities.Product;
import com.eclipse.UirShop.entities.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    List<Product> findByOrderByNbviewDesc();
    List<Product>findProductBySouscategorie(SousCategorie categorie);
}
