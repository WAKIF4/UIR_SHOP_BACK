package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategorieRepository  extends JpaRepository<Categorie,Long> {
}
