package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
