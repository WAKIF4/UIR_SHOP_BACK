package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.Categorie;
import com.eclipse.UirShop.entities.Product;
import com.eclipse.UirShop.entities.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    List<Product> findByOrderByNbviewDesc();
    @Query("SELECT p FROM Product p " +
            "INNER JOIN p.souscategorie sc " +
            "INNER JOIN sc.categorie c " +
            "WHERE c.id = :idcategorie")
    List<Product> findAllProductsByCat(@Param("idcategorie") Long yourCondition);
}
