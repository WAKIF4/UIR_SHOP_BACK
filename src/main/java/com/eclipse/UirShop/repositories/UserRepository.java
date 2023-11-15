package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
