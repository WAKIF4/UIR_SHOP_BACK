package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.Categorie;
import com.eclipse.UirShop.entities.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISousCategorieRepository extends JpaRepository<SousCategorie,Long> {
    List<SousCategorie> findSousCategorieByCategorie(Categorie cat);
}
