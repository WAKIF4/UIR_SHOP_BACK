package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ICategorieRepository  extends JpaRepository<Categorie,Long> {
}
