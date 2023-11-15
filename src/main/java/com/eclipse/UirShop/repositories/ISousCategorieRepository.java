package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISousCategorieRepository extends JpaRepository<SousCategorie,Long> {
}
