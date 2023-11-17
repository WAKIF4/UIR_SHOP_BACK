package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ICategorieRepository  extends JpaRepository<Categorie,Long> {
    Optional<Categorie> findCategorieByNom(String nom);

}
