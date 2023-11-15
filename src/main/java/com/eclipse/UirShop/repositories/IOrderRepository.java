package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
