package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}
